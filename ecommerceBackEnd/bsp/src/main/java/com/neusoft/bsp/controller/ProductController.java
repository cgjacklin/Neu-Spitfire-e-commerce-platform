package com.neusoft.bsp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.business.vo.ProductVO;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.mvo.service.ProductService;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
    public BaseModel addProduct(@RequestBody ProductVO productVO){
        BaseModel response = new BaseModel();
//        ProductVO productvo = JSONObject.parseObject(productStr,ProductVO.class);
//        System.out.println("INFO"+productvo.getWarranty());
        if(productService.addProduct(productVO)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/uploadPicture")
    public BaseModelJson<String> uploadPicture(@RequestParam(name = "fileName", required = false) MultipartFile uploadFile, HttpServletRequest request){
        String result = productService.uploadPicture(uploadFile, request);
        BaseModelJson<String> response = new BaseModelJson<>();
        response.setSuccess();
        response.setData(result);
        return response;
    }

    @PostMapping("/updateProduct")
    public BaseModel updateProduct(@RequestBody ProductVO productVO){
        BaseModel response = new BaseModel();
//        ProductVO productvo = JSONObject.parseObject(productStr,ProductVO.class);
//        System.out.println("INFO"+productvo.getWarranty());
        if(productService.updateProduct(productVO)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/deleteProduct")
    public BaseModel deleteProduct(@RequestBody Product product){
        BaseModel response = new BaseModel();
        if(productService.deleteProduct(product)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/deleteProduts")
    public BaseModel deleteProducrs(@RequestBody Map<String, String> products){
        BaseModel response = new BaseModel();
        JSONArray jsonArray = JSONArray.parseArray(products.get("products"));
        for(int i=0; i<jsonArray.size(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            int pro_id = Integer.parseInt(obj.getString("pro_id"));
            Product product = new Product(pro_id);
            productService.deleteProduct(product);
        }
        response.setSuccess();
        return response;
    }

    @PostMapping("/updateSts")
    public BaseModel updateSts(@RequestBody Product product){
        BaseModel response = new BaseModel();
        if(productService.updateSts(product)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/getProductOnShelf")
    public BaseModelJson<List<ProductVO>> getProductOnShelf(@RequestBody User user){
        BaseModelJson<List<ProductVO>> response = new BaseModelJson<>();
        List<ProductVO> products = productService.getProductsOnShelf(user);
        if(products!=null){
            response.setSuccess();
            response.setData(products);
        }else{
            throw BusinessException.NO_PRODUCT;
        }

        return response;
    }

}
