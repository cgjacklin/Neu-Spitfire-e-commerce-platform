package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/rle")
public class RoleController {

    @Autowired
    UserService userService;

    @PostMapping("/getUsers")
    public BaseModelJson<Map<String, Object>> getUsers(@Validated({SelectGroup.class}) @RequestBody int user_id) {
        User user = userService.getById(user_id);
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        if(user.getRole_id()!="0"){
            throw BusinessException.PERMISSION_DENY;
        }
        response.code = 200;
        HashMap<String, Object> res = new HashMap<>();
        List<User> list = userService.getAll();
            for (User i : list) {
                res.put("user", i);
            }
            response.data = res;
        return response;
    }
}
