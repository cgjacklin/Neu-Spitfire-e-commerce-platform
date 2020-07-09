package com.neusoft.bsp.business.mvo.service;

import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.OrderRequest;

import java.util.List;
import java.util.Map;

public interface OrderService {
    int insert(Order order);

    int update(Order order);

    int delete(int pk);

    Order getById(int pd);

    List<Order> getAll();

    List<Order> getAllByFilter(Map<String, Object> map);

    List<Order> getOrders(OrderRequest orderRequest);

    int deliverOrder(Order order);

    int cancelOrder(Order order);


}
