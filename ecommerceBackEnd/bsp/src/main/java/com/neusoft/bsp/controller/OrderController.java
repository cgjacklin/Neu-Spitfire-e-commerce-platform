package com.neusoft.bsp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.bsp.business.order.service.OrderService;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.CancelOrderRequest;
import com.neusoft.bsp.business.vo.OrderRequest;
import com.neusoft.bsp.business.vo.OrderResponse;
import com.neusoft.bsp.business.vo.PayOrderRequest;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    OrderService orderService;

    @PostMapping("/getOrders")
    public BaseModelJson<List<OrderResponse>> getOrders(@RequestBody OrderRequest orderRequest){
        BaseModelJson<List<OrderResponse>> response = new BaseModelJson<>();
        List<OrderResponse> results = orderService.getOrders(orderRequest);
        if(results!=null && results.size()!=0){
            response.setSuccess();
            response.setData(results);
        }else{
            throw BusinessException.NO_ORDER;
        }

        return response;
    }

    @PostMapping("/shipSelected")
    public BaseModel test(@RequestBody Map<String, String> orders){
        BaseModel response = new BaseModel();
        JSONArray jsonArray = JSONArray.parseArray(orders.get("orders"));
        String tracking_company = orders.get("tracking_company");
        System.out.println(jsonArray);
        System.out.println(tracking_company);
        for(int i=0; i<jsonArray.size(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            int or_id = Integer.parseInt(obj.getString("or_id"));
            Order order = new Order(or_id, tracking_company);
            orderService.deliverOrder(order);
        }
        response.setSuccess();
        return response;

//        for(Order order: orders){
//            System.out.println(order.getTracking_company());
//        }
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
    public BaseModel cancelOrder(@RequestBody CancelOrderRequest cancelOrderRequest){
        BaseModel response = new BaseModel();
        if(orderService.cancelOrder(cancelOrderRequest)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/payOrder")
    public BaseModel payOrder(@RequestBody PayOrderRequest payOrderRequest){
        BaseModel response = new BaseModel();
        if(orderService.payOrder(payOrderRequest)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }


}
