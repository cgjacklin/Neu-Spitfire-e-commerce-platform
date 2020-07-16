package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.mainPage.service.MainPageService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/mainPage")
public class MainPageController extends BaseController {
    @Autowired
    MainPageService mainPageService;
    @Autowired
    UserService userService;
    @RequestMapping("/getInfo")
    public BaseModelJson<Map<String, Object>> getInfo(@RequestBody User user){
        HashMap<String, Object> result = mainPageService.getInfo(user);
        BaseModelJson<Map<String, Object>> response = new BaseModelJson<>();
        response.setSuccess();
        response.setData(result);
        return response;

    }

    @RequestMapping("/getUserBasicInfo")
    public BaseModelJson<User> getUserBasicInfo(@RequestBody User user){
        BaseModelJson<User> response = new BaseModelJson<>();
        User result = mainPageService.getUserBasicInfo(user);
        response.setSuccess();
        response.setData(result);
        return response;
    }

    @RequestMapping("updateUserBasicInfo")
    public BaseModel updateUserBasicInfo(@RequestBody User user){
        BaseModel response = new BaseModel();
        if(userService.updateBasicInfo(user)==1){
            response.setSuccess();
        }
        else {
            response.setFailure();
        }
        return response;
    }
}
