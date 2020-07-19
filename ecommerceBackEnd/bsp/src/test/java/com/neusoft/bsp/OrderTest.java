package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.OrderRequest;
import com.neusoft.bsp.business.vo.OrderResponse;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.OrderController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
 class OrderTest {

    @Autowired
    OrderController orderController;

    @Test
    void getOrders_noOrder() {
        OrderRequest orderRequest =new OrderRequest();
        orderRequest.setUser_id(1);
        orderRequest.setSts_cd("1");
        assertThrows(BusinessException.class, () -> {
            BaseModelJson<List<OrderResponse>> bmj = orderController.getOrders(orderRequest);
        });
    }

    @Test
    void getOrders_success() {
        OrderRequest orderRequest =new OrderRequest();
        orderRequest.setUser_id(6);
        orderRequest.setSts_cd("1");

        BaseModelJson<List<OrderResponse>> bmj = orderController.getOrders(orderRequest);
        assertEquals(200, bmj.code);
    }

    @Test
    void deliverOrder_success() {
        Order order=new Order();
        order.setOr_id(1);

        BaseModel bmj = orderController.deliverOrder(order);
        assertEquals(200, bmj.code);
    }
}
