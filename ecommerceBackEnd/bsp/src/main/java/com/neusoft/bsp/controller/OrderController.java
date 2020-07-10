package com.neusoft.bsp.controller;

import com.neusoft.bsp.business.order.service.OrderService;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.OrderRequest;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    OrderService orderService;

    @PostMapping("/getOrders")
    public BaseModelJson<List<Order>> getOrders(@RequestBody OrderRequest orderRequest){
        BaseModelJson<List<Order>> response = new BaseModelJson<>();
        List<Order> results = orderService.getOrders(orderRequest);
        if(results!=null && results.size()!=0){
            response.setSuccess();
            response.setData(results);
        }else{
            throw BusinessException.NO_ORDER;
        }

        return response;
    }

    @PostMapping("/deliverOrder")
    public BaseModel deliverOrder(@RequestBody Order order){
        BaseModel response = new BaseModel();
        if(orderService.deliverOrder(order)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/cancelOrder")
    public BaseModel cancelOrder(@RequestBody Order order){
        BaseModel response = new BaseModel();
        if(orderService.cancelOrder(order)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }


}
