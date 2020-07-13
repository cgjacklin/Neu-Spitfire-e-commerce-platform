package com.neusoft.bsp.business.order.service;

import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.CancelOrderRequest;
import com.neusoft.bsp.business.vo.OrderRequest;
import com.neusoft.bsp.business.vo.OrderResponse;
import com.neusoft.bsp.business.vo.PayOrderRequest;

import java.util.List;
import java.util.Map;

public interface OrderService {
    int insert(Order order);

    int update(Order order);

    int delete(int pk);

    Order getById(int pd);

    List<Order> getAll();

    List<Order> getAllByFilter(Map<String, Object> map);

    List<OrderResponse> getOrders(OrderRequest orderRequest);

    int deliverOrder(Order order);

    int cancelOrder(CancelOrderRequest cancelOrderRequest);

    int payOrder(PayOrderRequest order);
}
