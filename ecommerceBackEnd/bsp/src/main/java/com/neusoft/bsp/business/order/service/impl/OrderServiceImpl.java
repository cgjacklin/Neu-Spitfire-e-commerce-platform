package com.neusoft.bsp.business.order.service.impl;

import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.wallet.po.WalletAccount;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.admin.wallet.po.WalletTransactionRecord;
import com.neusoft.bsp.admin.wallet.service.WalletAccountFundService;
import com.neusoft.bsp.admin.wallet.service.WalletAccountService;
import com.neusoft.bsp.admin.wallet.service.WalletTransactionRecordService;
import com.neusoft.bsp.business.order.mapper.OrderMapper;
import com.neusoft.bsp.business.mvo.mapper.ProductMapper;
import com.neusoft.bsp.business.order.service.OrderService;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.vo.CancelOrderRequest;
import com.neusoft.bsp.business.vo.OrderRequest;
import com.neusoft.bsp.business.vo.OrderResponse;
import com.neusoft.bsp.business.vo.PayOrderRequest;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("OrderService")
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    WalletAccountService walletAccountService;
    @Autowired
    WalletAccountFundService walletAccountFundService;
    @Autowired
    WalletTransactionRecordService walletTransactionRecordService;

    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public int delete(int pk) {
        return orderMapper.delete(pk);
    }

    @Override
    public Order getById(int pd) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getAllByFilter(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<OrderResponse> getOrders(OrderRequest orderRequest) {
        int user_id = orderRequest.getUser_id();
        String sts_cd = orderRequest.getSts_cd();
        User user = userMapper.getById(user_id);
        int man_buyer_id = user.getMan_buyer_id();
        HashMap<String, Object> para = new HashMap<>();
        para.put("sts_cd", sts_cd);
        para.put("role_id", user.getRole_id());
        para.put("man_buyer_id", man_buyer_id);
        System.out.println("ROLEID: "+user.getRole_id());
        System.out.println(para.toString());
        List<Order> orders = orderMapper.getAllByFilter(para);
        List<OrderResponse> orderResponses = new LinkedList<>();
        for(Order o:orders){
            Product product = productMapper.getById(o.getPro_id());
            String title = product.getTitle();
            OrderResponse orderResponse = new OrderResponse(o, title);
            orderResponse.setRemark(product.getRemark());
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    @Override
    public int deliverOrder(Order order) {
        Order new_order = orderMapper.getById(order.getOr_id());
        if(!new_order.getSts_cd().equals("2")){
            throw BusinessException.ORDER_STATUS_WRONG;
        }

        //生成tracking number
        StringBuffer sBuffer = new StringBuffer("");

        for(int i=0;i<10;i ++) {
            int tmp = (int)(10*(Math.random()));
            sBuffer.append(tmp);
        }

        new_order.setSts_cd("3");
        new_order.setTracking_number(sBuffer.toString());
        new_order.setTracking_company(order.getTracking_company());


        long time = System.currentTimeMillis();
        Timestamp datetime = new java.sql.Timestamp(time);
        new_order.setShip_time(datetime);
        return orderMapper.update(new_order);
    }

    @Override
    public int cancelOrder(CancelOrderRequest request) {

        //获取订单
        Order order = orderMapper.getById(request.getOr_id());

        //计算花费金额，时间等变量
        BigDecimal paidMoney = order.getSales_price().multiply(new BigDecimal(order.getQty()));
        Timestamp datetime = new java.sql.Timestamp(System.currentTimeMillis());

        //买家信息
        int dsr_id = order.getDsr_id();
        Map<String, Object> map = new HashMap<>();
        map.put("man_buyer_id", dsr_id);
        map.put("role_id","2");
        User userBuyer = userMapper.getBuyerOrSeller(map);

        //买家和卖家的钱包账户
        WalletAccount walletAccountSeller = walletAccountService.getById(request.getUser_id());
        WalletAccount walletAccountBuyer = walletAccountService.getById(userBuyer.getUser_id());

        //钱包类
        WalletAccountFund walletAccountFundSeller = walletAccountFundService.getById(request.getUser_id());
        WalletAccountFund walletAccountFundBuyer = walletAccountFundService.getById(userBuyer.getUser_id());
        WalletTransactionRecord walletTransactionRecord =new WalletTransactionRecord();

        //验证余额是否足够
        if(walletAccountFundSeller.getAvailable_money().compareTo(paidMoney)<0){
            throw BusinessException.NOT_SUFFICIENT_FUNDS;
        }

        //公共业务逻辑
        walletTransactionRecord.setBuyer_id(userBuyer.getUser_id());
        walletTransactionRecord.setTransaction_type(3);
        walletTransactionRecord.setTransaction_money(paidMoney);
        walletTransactionRecord.setStatus(2);
        walletTransactionRecord.setCreate_time(datetime);
        walletTransactionRecord.setLast_update_time(datetime);
        walletTransactionRecord.setBusiness_id(order.getOr_id());

        //卖家业务逻辑
        walletTransactionRecord.setAccount_name(walletAccountSeller.getAccount_name());
        walletTransactionRecord.setCreate_by(walletAccountSeller.getAccount_name());
        walletTransactionRecord.setLast_update_by(walletAccountSeller.getAccount_name());
        int j = walletTransactionRecordService.insert(walletTransactionRecord);
        if(j!=1){
            throw BusinessException.INSERT_FAIL;
        }

        //买家业务逻辑
        walletTransactionRecord.setBuyer_id(request.getUser_id());
        walletTransactionRecord.setTransaction_money(paidMoney.negate());
        walletTransactionRecord.setAccount_name(walletAccountBuyer.getAccount_name());

        if(walletTransactionRecordService.insert(walletTransactionRecord) != 1){
            throw BusinessException.INSERT_FAIL;
        }

        //钱包余额 卖家
        BigDecimal oriMoneySeller = walletAccountFundSeller.getAvailable_money();
        walletAccountFundSeller.setAvailable_money(oriMoneySeller.subtract(paidMoney));
        walletAccountFundSeller.setLast_update_time(datetime);
        walletAccountFundService.update(walletAccountFundSeller);

        //钱包余额 买家
        BigDecimal oriMoneyBuyer = walletAccountFundBuyer.getAvailable_money();
        walletAccountFundBuyer.setAvailable_money(oriMoneyBuyer.add(paidMoney));
        walletAccountFundBuyer.setLast_update_time(datetime);
        walletAccountFundService.update(walletAccountFundBuyer);

        order.setCancelled_time(datetime);
        order.setSts_cd("0");
        return orderMapper.update(order);
    }

    @Override
    public int payOrder(PayOrderRequest request) {
        Order order = orderMapper.getById(request.getOr_id());
        BigDecimal paidMoney = order.getSales_price().multiply(new BigDecimal(order.getQty()));
        WalletAccountFund walletAccountFundBuyer = walletAccountFundService.getById(request.getUser_id());
        WalletTransactionRecord walletTransactionRecord =new WalletTransactionRecord();
        //验证订单状态
        if(!order.getSts_cd().equals("1")){
            throw BusinessException.ORDER_STATUS_WRONG;
        }
        //卖家信息
        int man_id = order.getMan_id();
        Map<String, Object> map = new HashMap<>();
        map.put("man_buyer_id", man_id);
        map.put("role_id","1");
        User userSeller = userMapper.getBuyerOrSeller(map);
        WalletAccount walletAccountSeller = walletAccountService.getById(userSeller.getUser_id());

        //校验账户是否存在，密码是否正确以及余额是否足够
        WalletAccount walletAccountBuyer = walletAccountService.getById(request.getUser_id());
        if(walletAccountBuyer.getIs_active().equals("N")){
            throw BusinessException.WALLET_ACCOUNT_STATUS_WRONG;
        }
        if(!walletAccountBuyer.getPassword().equals(request.getPassword())){
            throw BusinessException.PASSWORD_WRONG;
        }
        if(walletAccountFundBuyer.getAvailable_money().compareTo(paidMoney)<0){
            throw BusinessException.BUYER_NOT_SUFFICIENT_FUNDS;
        }
        //公共业务逻辑
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        walletTransactionRecord.setCreate_by(walletAccountBuyer.getAccount_name());
        walletTransactionRecord.setLast_update_by(walletAccountBuyer.getAccount_name());
        walletTransactionRecord.setStatus(2);
        walletTransactionRecord.setTransaction_type(3);
        walletTransactionRecord.setCreate_time(datetime);
        walletTransactionRecord.setLast_update_time(datetime);
        walletTransactionRecord.setBusiness_id(order.getOr_id());


        //买家业务逻辑
        walletTransactionRecord.setBuyer_id(request.getUser_id());
        walletTransactionRecord.setAccount_name(walletAccountBuyer.getAccount_name());
        walletTransactionRecord.setTransaction_money(paidMoney.negate());
        int j = walletTransactionRecordService.insert(walletTransactionRecord);
        if(j!=1){
            throw BusinessException.INSERT_FAIL;
        }

        //卖家业务逻辑
        walletTransactionRecord.setBuyer_id(userSeller.getUser_id());
        walletTransactionRecord.setTransaction_money(paidMoney);
        walletTransactionRecord.setAccount_name(walletAccountSeller.getAccount_name());

        if(walletTransactionRecordService.insert(walletTransactionRecord) != 1){
            throw BusinessException.INSERT_FAIL;
        }


        //钱包余额 卖家
        WalletAccountFund walletAccountFundSeller = walletAccountFundService.getById(userSeller.getUser_id());
        BigDecimal oriMoneySeller = walletAccountFundSeller.getAvailable_money();
        walletAccountFundSeller.setAvailable_money(oriMoneySeller.add(paidMoney));
        walletAccountFundSeller.setLast_update_time(datetime);
        walletAccountFundService.update(walletAccountFundSeller);

        //钱包余额 买家
        BigDecimal oriMoneyBuyer = walletAccountFundBuyer.getAvailable_money();
        walletAccountFundBuyer.setAvailable_money(oriMoneyBuyer.subtract(paidMoney));
        walletAccountFundBuyer.setLast_update_time(datetime);
        walletAccountFundService.update(walletAccountFundBuyer);

        //更新订单状态
        order.setSts_cd("2");
        order.setPaid_time(datetime);
        return orderMapper.update(order);
    }



}
