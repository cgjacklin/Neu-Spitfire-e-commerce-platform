package com.neusoft.bsp.controller;


import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import com.neusoft.bsp.mvo.entity.Manufacturer;
import com.neusoft.bsp.mvo.service.ManufacturerService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static java.time.LocalDate.now;

@CrossOrigin
@RestController
@RequestMapping("/bvo")
public class MVOInfoController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    ManufacturerService manufacturerService;

    /**
     *用id获取
     */
    @PostMapping("/getManufacturerByUserID")
    public BaseModelJson<Manufacturer> getManufacturerByUserID(@Validated({SelectGroup.class}) @RequestBody int user_id, BindingResult bindingResult) {
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

    /**
     *新增公司信息
     */
    @PostMapping("/addManufacturer")
    public BaseModel addManufacturer(@RequestParam int user_id, @RequestParam String name_en,
                                     @RequestParam String gmc_report_type, @RequestParam String gmc_report_url,
            @RequestParam String description) {
        BaseModel result = new BaseModel();
        Manufacturer manufacturer = new Manufacturer(name_en,gmc_report_type,gmc_report_url,description);
        String name = userService.getById(user_id).getName();
        manufacturer.setCreated_by(name);
        manufacturer.setLast_update_by(name);
        manufacturer.setLast_update_date(Date.valueOf(now()));
        manufacturer.setCreation_date(Date.valueOf(now()));

        int i = manufacturerService.insert(manufacturer);   //manufacturer表插入

        int j = manufacturerService.updateUserWithLastManu(user_id);    //sys_user表还没更新
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

    @PostMapping("/updateManufacturer")
    public BaseModel updateManufacturer(@Validated({UpdateGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息

        BaseModel result = new BaseModel();
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
