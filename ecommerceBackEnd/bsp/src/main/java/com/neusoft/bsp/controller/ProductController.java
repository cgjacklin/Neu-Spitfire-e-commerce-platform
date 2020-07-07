package com.neusoft.bsp.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.bsp.business.vo.ProductVO;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @PostMapping("/getProducts")
    public BaseModelJson<List<ProductVO>> getProducts(@RequestBody User user){
        BaseModelJson<List<ProductVO>> response = new BaseModelJson<>();
        List<ProductVO> products = productService.getProducts(user);
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
        ProductVO productvo = JSONObject.parseObject(productStr,ProductVO.class);
//        System.out.println("INFO"+productvo.getWarranty());
        if(productService.addProduct(productvo, file)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/updateProduct")
    public BaseModel updateProduct(@RequestParam String productStr, @RequestParam("fileName") MultipartFile file){
        BaseModel response = new BaseModel();
        ProductVO productvo = JSONObject.parseObject(productStr,ProductVO.class);
//        System.out.println("INFO"+productvo.getWarranty());
        if(productService.updateProduct(productvo, file)==1){
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

    @PostMapping("updateSts")
    public BaseModel updateSts(@RequestBody Product product){
        BaseModel response = new BaseModel();
        if(productService.updateSts(product)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("getProductOnShelf")
    public BaseModelJson<List<ProductVO>> getProductOnShelf(){
        BaseModelJson<List<ProductVO>> response = new BaseModelJson<>();
        List<ProductVO> products = productService.getProductsOnShelf();
        if(products!=null){
            response.setSuccess();
            response.setData(products);
        }else{
            throw BusinessException.NO_PRODUCT;
        }

        return response;
    }

}
