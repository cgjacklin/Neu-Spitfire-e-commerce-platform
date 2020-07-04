package com.neusoft.bsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.service.ProductService;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @PostMapping("/getProducts")
    public BaseModelJson<List<Product>> getProducts(@RequestBody User user){
        BaseModelJson<List<Product>> response = new BaseModelJson<>();
        List<Product> products = productService.getProducts(user);
        if(products!=null){
            response.setSuccess();
            response.setData(products);
        }else{
            throw BusinessException.NO_PRODUCT;
        }

        return response;
    }

    @PostMapping("/addProduct")
    public BaseModel addProduct(@RequestParam String productStr, @RequestParam("fileName") MultipartFile file){
        BaseModel response = new BaseModel();
        Product product = JSONObject.parseObject(productStr,Product.class);
        if(productService.addProduct(product, file)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/updateProduct")
    public BaseModel updateProduct(@RequestParam String productStr, @RequestParam("fileName") MultipartFile file){
        BaseModel response = new BaseModel();
        Product product = JSONObject.parseObject(productStr,Product.class);
        if(productService.updateProduct(product, file)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("deleteProduct")
    public BaseModel deleteProduct(@RequestBody Product product){
        BaseModel response = new BaseModel();
        if(productService.deleteProduct(product)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }



}
