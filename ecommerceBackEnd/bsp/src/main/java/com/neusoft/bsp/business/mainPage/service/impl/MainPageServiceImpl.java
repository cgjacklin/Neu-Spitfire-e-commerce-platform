package com.neusoft.bsp.business.mainPage.service.impl;

import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.admin.wallet.service.WalletAccountFundService;
import com.neusoft.bsp.business.mainPage.service.MainPageService;
import com.neusoft.bsp.business.mvo.mapper.ProductMapper;
import com.neusoft.bsp.business.order.mapper.OrderMapper;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service("MainPageService")
public class MainPageServiceImpl implements MainPageService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    WalletAccountFundService walletAccountFundService;

    @Override
    public HashMap<String, Object> getInfo(User user) {
        HashMap<String, Object> res = new HashMap<>();
        User realUser = userMapper.getById(user.getUser_id());
        String roleId = realUser.getRole_id();
        String role = new String();
        if(roleId.equals("0")){
            role = "Admin";
        }
        if(roleId.equals("1")){
            role = "Brand-seller";
        }
        if(roleId.equals("2")){
            role = "Borrow-seller";
        }
        res.put("role", role);

        List<Product> products = productMapper.getAll();
        int totalProducts = products.size();
        res.put("goods", totalProducts);

        List<Order> orders = orderMapper.getAll();
        int totalOrder = orders.size();
        res.put("orders", totalOrder);

        WalletAccountFund walletAccountFund = walletAccountFundService.getById(user.getUser_id());
        if(walletAccountFund==null){
            res.put("wallet", "-");
        }else{
            res.put("wallet", walletAccountFundService.getById(user.getUser_id()).getAvailable_money());
        }




        return  res;
    }

    @Override
    public User getUserBasicInfo(User user) {
        User realUser = userMapper.getById(user.getUser_id());
        return realUser;
    }
}
