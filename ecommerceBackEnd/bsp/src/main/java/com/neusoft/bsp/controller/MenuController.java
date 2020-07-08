package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.service.MenuService;
import com.neusoft.bsp.admin.menu.vo.MenuWithUserID;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.business.po.Store;
import com.neusoft.bsp.business.vo.StoreWithUserAndStr;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
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
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;
    /**
     *通过user_id验证role_id从而返回List
     */
    @PostMapping("/getAllMenuList")
    public BaseModelJson<List<Menu>> getAllMenuList(@RequestBody int user_id) {
        BaseModelJson<List<Menu>> result = new BaseModelJson<>();
        User user = userService.getById(user_id);
        int role_id = Integer.parseInt(user.getRole_id());
        if (role_id == 0) {
            result.code = 200;
            List<Menu> menus = menuService.getAll();
            if (menus.size() == 0) {
                result.message = "no data";
            } else {
                result.data = menus;
            }
            return result;
        } else {
            throw BusinessException.NO_PERMISSION;
        }

    }

    @PostMapping("/updateMenuInfo")
    public BaseModel updateMenuInfo(@Validated({UpdateGroup.class}) @RequestBody MenuWithUserID menuWithUserID, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息

        if (bindingResult.hasErrors()) {    //传值错误
            throw BusinessException.UPDATE_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{menuWithUserID.toString()});
        }else{
            BaseModel result = new BaseModel();
            int role_id = Integer.parseInt(userService.getById(menuWithUserID.getUser_id()).getRole_id());
            if(role_id == 0){
                Menu menu = new Menu(menuWithUserID.getMenu_id(),menuWithUserID.getMenu_name());
                int i = menuService.update(menu);
                if(i==1){
                    result.code = 200;
                    return result;
                }else {
                    throw BusinessException.UPDATE_FAIL;
                }
            }else{
                throw BusinessException.NO_PERMISSION;
            }

        }
    }
}
