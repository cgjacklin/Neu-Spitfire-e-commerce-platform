package com.neusoft.bsp.business.mvo.service.impl;

import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.mvo.mapper.OrderMapper;
import com.neusoft.bsp.business.mvo.mapper.ProductMapper;
import com.neusoft.bsp.business.mvo.service.OrderService;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

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
    public List<Order> getOrders(OrderRequest orderRequest) {
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
        return orderMapper.getAllByFilter(para);

//        if(user.getRole_id().equals("1")){
//            para.put("man_id", man_buyer_id)
//            orderMapper.getAllByManId()
//        }
//        if(user.getRole_id().equals("2")){
//
//        }
//        if(user.getRole_id().equals("0")){
//
//        }
    }

    @Override
    public int deliverOrder(Order order) {
        Order new_order = orderMapper.getById(order.getOr_id());
        new_order.setSts_cd("3");
        new_order.setTracking_number(order.getTracking_number());
        new_order.setTracking_company(order.getTracking_company());

        long time = System.currentTimeMillis();
        Timestamp datetime = new java.sql.Timestamp(time);
        new_order.setShip_time(datetime);
        return orderMapper.update(new_order);
    }

    @Override
    public int cancelOrder(Order order) {
        Order new_order = orderMapper.getById(order.getOr_id());
        new_order.setSts_cd("0");
//        new_order.setTracking_number(order.getTracking_number());

        long time = System.currentTimeMillis();
        Timestamp datetime = new java.sql.Timestamp(time);
        new_order.setCancelled_time(datetime);
        return orderMapper.update(new_order);
    }
}
