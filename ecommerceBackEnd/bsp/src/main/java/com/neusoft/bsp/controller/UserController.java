package com.neusoft.bsp.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.security.service.AuthService;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @PostMapping("/addUser")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = userService.insert(user);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/checkUser")
    public BaseModel getAllByFilter(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        List<User> users = userService.getAllByFilter(map);
        if (users.size() == 0) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        } else {
            BaseModel result = new BaseModel();
            result.message = authService.login(user);
            result.code = 200;
            return result;
        }
    }

    @PostMapping("/deleteUser")
    public BaseModel deleteUser(@Validated({DeleteGroup.class}) @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = userService.delete(user.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateUser")
    public BaseModel updateUser(@Validated({UpdateGroup.class}) @RequestBody User user, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =userService.update(user);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }

    @PostMapping("/userlist")
    public BaseModelJson<PageInfo<User>> getUserList(Integer pageNum, Integer pageSize,
                                                     @RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        BaseModelJson<PageInfo<User>> result = new BaseModelJson();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        result.code = 200;
        result.data = userService.getAllByFilter(pageNum, pageSize, map);

        return result;
    }



}
