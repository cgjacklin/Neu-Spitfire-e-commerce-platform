package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.bvo.service.StoreService;
import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.business.po.Store;
import com.neusoft.bsp.business.vo.StoreWithUserAndStr;
import com.neusoft.bsp.business.vo.StoreWithUserId;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static java.time.LocalDate.now;


@CrossOrigin
@RestController
@RequestMapping("/str")
public class StoreController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    StoreService storeService;

    /**
     *新增店铺
     */
    @PostMapping("/addStore")
    public BaseModel addStore(@Validated({InsertGroup.class}) @RequestBody StoreWithUserId sto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{sto.toString()});
        }else{
            BaseModel result = new BaseModel();
            User user = userService.getById(sto.getUser_id());
            if(user == null){                         //判断用户是否存在
                throw BusinessException.USERNAME_NOT_EXISTS;
            }
            int dsr_id = user.getMan_buyer_id();
            if(dsr_id == 0){                          //判断借卖方信息是否存在
                throw BusinessException.NO_DSR_ID;
            }
            Store store = new Store(dsr_id,sto.getPlataeform_type(),sto.getStore_name(),sto.getStore_sts_cd());
            store.setCreated_by(user.getName());
            store.setCreation_date(Date.valueOf(now()));
            store.setLast_update_by(user.getName());
            store.setLast_update_date(Date.valueOf(now()));
            int i = storeService.insert(store);
            if(i == 1){
                result.code = 200;
                return result;
            }else {
                throw BusinessException.INSERT_FAIL;
            }

        }
    }

    /**
     *用id获取
     */
    @PostMapping("/getStoreByUserID")
    public BaseModelJson<List<Store>> getStoreByUserID(@RequestBody int user_id) {
        User user = userService.getById(user_id);
        BaseModelJson<List<Store>> result = new BaseModelJson<>();
        if(user==null){   //用户id不存在
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        int dsr_id = user.getMan_buyer_id();
        if(dsr_id == 0){
            throw BusinessException.NO_DSR_ID;
        }
        List<Store> storeList = storeService.getAllByDsrId(dsr_id);
        result.code = 200;
        if(storeList.size()==0){
            result.message = "There's no store information";
        }else {
            result.data = storeList;
        }
        return result;
    }

    @PostMapping("/updateStore")
    public BaseModel updateStore(@Validated({UpdateGroup.class}) @RequestBody StoreWithUserAndStr sto, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.UPDATE_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{sto.toString()});
        }else{
            BaseModel result = new BaseModel();

            int i = userService.getById(sto.getUser_id()).getMan_buyer_id();
            int j = storeService.getById(sto.getStr_id()).getDsr_id();
            if(i!=0&&i==j){                               //用户、店铺id匹配
                Store store = new Store(sto.getPlataeform_type(),sto.getStore_name(),sto.getStore_sts_cd());
                store.setStr_id(sto.getStr_id());
                store.setLast_update_date(Date.valueOf(now()));
                int k = storeService.update(store);
                if(k==1){
                    result.code = 200;
                    return result;
                }else{
                    throw BusinessException.UPDATE_FAIL;
                }
            }else{
                throw BusinessException.NP_PERMISSION;
            }
        }
    }

    @PostMapping("/deleteStore")
    public BaseModel deleteStore(@RequestParam int user_id, @RequestParam int str_id) {

        int i = storeService.delete(str_id);
        BaseModel result = new BaseModel();
        if(i==1){
            result.code = 200;
            return result;
        }else{
            throw BusinessException.DELETE_FAIL;
        }
    }
}
