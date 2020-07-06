package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.business.mvo.service.BrandService;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/brd")
public class BrandController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    BrandService brandService;

    @PostMapping("/getBrand")
    public  BaseModelJson<Map<String, Object>> getAllByFilter(@Validated({SelectGroup.class}) @RequestBody int user_id){
        User user = userService.getById(user_id);
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        if(user==null){   //用户id不存在
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        int manid = user.getMan_buyer_id();
        response.code = 200;
        if(manid != 0){
            HashMap<String, Object> res = new HashMap<>();
            List<Brand> list = brandService.getAllById(manid);
            for (Brand brand : list) {
                res.put("data", brand);
            }
            response.data = res;
        }
        return response;
    }




}
