package com.neusoft.bsp.controller;

import com.neusoft.bsp.business.vo.ManufacturerWithManID;
import com.neusoft.bsp.business.vo.ManufacturerWithUserId;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.business.mvo.service.ManufacturerService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static java.time.LocalDate.now;

@CrossOrigin
@RestController
@RequestMapping("/mvo")
public class MVOInfoController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    /**
     *新增公司信息
     */
    @PostMapping("/addManufacturer")
    public BaseModel addManufacturer(@Validated({InsertGroup.class}) @RequestBody ManufacturerWithUserId manu, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manu.toString()});
        }else{
            BaseModel result = new BaseModel();
            Manufacturer manufacturer = new Manufacturer(manu.getName_en(),manu.getGmc_report_type(),manu.getGmc_report_url(),manu.getDescription());
            String name = userService.getById(manu.getUser_id()).getName();
            manufacturer.setCreated_by(name);
            manufacturer.setLast_update_by(name);
            manufacturer.setLast_update_date(Date.valueOf(now()));
            manufacturer.setCreation_date(Date.valueOf(now()));
            int i = manufacturerService.insert(manufacturer);   //manufacturer表插入

            int j = manufacturerService.updateUserWithLastManu(manu.getUser_id());    //sys_user表还没更新
            if (i != 1) {
                throw BusinessException.INSERT_FAIL;
            }
            else if(j != 1){
                throw BusinessException.UPDATE_FAIL; }
            else{
                result.code = 200;
                return result;
            }
        }
    }

    /**
     *用id获取
     */
    @PostMapping("/getManufacturerByUserID")
    public BaseModelJson<Manufacturer> getManufacturerByUserID(@RequestBody int user_id) {
        User user = userService.getById(user_id);
        BaseModelJson<Manufacturer> result = new BaseModelJson<>();
        if(user==null){   //用户id不存在
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        int manufacturerID = user.getMan_buyer_id();  //获得manuID
        result.code = 200;

        if(manufacturerID != 0){     //有信息的老用户
            result.data = manufacturerService.getById(manufacturerID);
        }
        return result;
    }

    @PostMapping("/updateManufacturer")
    public BaseModel updateManufacturer(@Validated({UpdateGroup.class}) @RequestBody ManufacturerWithManID manu, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.UPDATE_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manu.toString()});
        }else{
            BaseModel result = new BaseModel();
            Manufacturer manufacturer = new Manufacturer(manu.getMan_id(),manu.getName_en(),manu.getGmc_report_type(),manu.getGmc_report_url(),manu.getDescription());
            manufacturer.setLast_update_date(Date.valueOf(now()));
            int i =manufacturerService.update(manufacturer);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
            }
    }

    @PostMapping("/deleteManufacturer")
    public BaseModel deleteManufacturer(@RequestBody int man_id) {

        int i = manufacturerService.delete(man_id);
        int j = manufacturerService.updateUserWithManuID(man_id);
        BaseModel result = new BaseModel();
        if(i==1 && j==1){
            result.code = 200;
            return result;
        }else{
            throw BusinessException.DELETE_FAIL;
        }
    }

}
