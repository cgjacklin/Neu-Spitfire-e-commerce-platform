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
    public BaseModel addUser(@RequestBody User user, BindingResult bindingResult) {
        User checkName = userService.getByUserName(user.getUsername());
        if(checkName!=null){
            throw BusinessException.DUPLICATE_USERNAME;
        }

        BaseModel result = new BaseModel();
        int i = userService.insert(user);

        if (i == 1) {
            result.code = 200;
            return result;
        } else {
            throw BusinessException.INSERT_FAIL;
        }
    }

    @PostMapping("/checkUsername")
    public BaseModel checkUsername(@RequestBody User user){
        User checkName = userService.getByUserName(user.getUsername());
        if(checkName!=null){
            throw BusinessException.DUPLICATE_USERNAME;
        }
        BaseModel result = new BaseModel();
        result.code = 200;
        return result;
    }

    @PostMapping("/checkUser")
    public  BaseModelJson<Map<String, String>> getAllByFilter(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        User checkName = userService.getByUserName(user.getUsername());
        if(checkName==null){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        List<User> users = userService.getAllByFilter(map);
        if (users.size() == 0) {
            throw BusinessException.PASSWORD_WRONG;
        } else {
            BaseModelJson<Map<String, String>> result = new BaseModelJson();
            HashMap<String, String> res = new HashMap<>();
            res.put("jwt", authService.login(user));
            res.put("user_id", checkName.getUser_id()+"");
//            result.message = authService.login(user);
            result.data = res;
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

    @PostMapping("/userAuth")
    public BaseModelJson<String[]> getAuth(@RequestBody Map<String, String> param){
        int uid = Integer.parseInt(param.get("user_id"));
//        int uid = user.getId();
        User user = userService.getById(uid);
//        System.out.println(user.getUsername());

        BaseModelJson<String[]> result = new BaseModelJson<>();
        result.code = 200;
        result.data = userService.getRights(user);
//        System.out.println(user.getId());
//        BaseModelJson<Map<String, List<String>>> result = new BaseModelJson<>();
        return result;
    }

}
