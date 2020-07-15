package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.admin.user.vo.UserIdAndDeleteId;
import com.neusoft.bsp.admin.user.vo.UserIdAndUpdate;
import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.business.po.PackageInfo;
import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.business.vo.BrandWithBrdId;
import com.neusoft.bsp.business.vo.UserIdAndProId;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.now;

@CrossOrigin
@RestController
@RequestMapping("/rle")
public class RoleController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/getUsers")
    public BaseModelJson<Map<String, Object>> getUsers(@Validated({SelectGroup.class}) @RequestBody User user) {
        int user_id = user.getUser_id();
        user = userService.getById(user_id);
        BaseModelJson<Map<String, Object>> response = new BaseModelJson();
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        String per = user.getRole_id();
        if(per.equals("0")) {
            response.code = 200;
            HashMap<String, Object> res = new HashMap<>();
            List<User> list = userService.getAll();
            res.put("user", list);
            response.data = res;
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
        return response;
    }


    @PostMapping("/deletedUser")
    public BaseModel deletedUser(@RequestBody UserIdAndDeleteId uad) {
        User user = userService.getById(uad.getUser_id());
        BaseModel result = new BaseModel();
        if (user == null) {
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        String per = user.getRole_id();
        if(per.equals("0")) {
            int delete_id = uad.getDelete_id();
            int i = userService.delete(delete_id);
            if(i!=1){
                throw BusinessException.DELETE_FAIL;
            }else{
                result.code = 200;
                return result;
            }
        }else{
            throw BusinessException.PERMISSION_DENY;
        }
    }


    @PostMapping("/updateUser")
    public BaseModel updateUser(@Validated({UpdateGroup.class}) @RequestBody UserIdAndUpdate uau, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.UPDATE_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{uau.toString()});
        }else{
            BaseModel result = new BaseModel();
            User user = userService.getById(uau.getAdmin_id());
            if (user == null) {
                throw BusinessException.USERNAME_NOT_EXISTS;
            }
            String per = user.getRole_id();
            if(per.equals("0")) {
            User user1 = userService.getById(uau.getUser_id());
            user1.setUsername(uau.getUsername());
            user1.setPassword(uau.getPassword());
            user1.setName(uau.getName());
            user1.setLast_login(Date.valueOf(now()).toString());
//            user1.setIp(uau.getIp());
//            user1.setStatus(uau.getStatus());
//            user1.setBz(uau.getBz());
//            user1.setSkin(uau.getSkin());
            user1.setEmail(uau.getEmail());
//            user1.setNumber(uau.getNumber());
            user1.setPhone(uau.getPhone());
            user1.setRole_id(uau.getRole_id());
//            user1.setMan_buyer_id(uau.getMan_buyer_id());
            int i = userService.update(user1);
                if(i!=1){
                    throw BusinessException.UPDATE_FAIL;
                }else{
                    result.code = 200;
                    return result;
                }
            }else{
                throw BusinessException.PERMISSION_DENY;
            }
        }
    }

}
