package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.menu.mapper.MenuListMapper;
import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.po.MenuList;
import com.neusoft.bsp.admin.menu.service.MenuListService;
import com.neusoft.bsp.admin.menu.service.MenuService;
import com.neusoft.bsp.admin.menu.vo.MenuDetailWithID;
import com.neusoft.bsp.admin.menu.vo.MenuListItem;
import com.neusoft.bsp.admin.menu.vo.MenuWithIDAndState;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *权限管理
 */

@CrossOrigin
@RestController
@RequestMapping("/menuList")
public class MenuListController {

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @Autowired
    MenuListService menuListService;


    /**
     *管理某人权限之初，获得menu列表并显示状态。
     */
    @PostMapping("/getAllMenusWithState")
    public BaseModelJson<List<MenuWithIDAndState>> getAllMenusWithState(@RequestBody User us){

        BaseModelJson<List<MenuWithIDAndState>> result = new BaseModelJson<>();

        List<Menu> allMenu = menuService.getAll();
        List<MenuWithIDAndState> menuWithIDAndStates = new ArrayList<>();

        for (Menu menu : allMenu) {            //将数据库数据转换为前端menu
            MenuWithIDAndState menuList = new MenuWithIDAndState();

            menuList.setMenu_id(menu.getMenu_id());
            menuList.setMenu_icon(menu.getMenu_icon());
            menuList.setMenu_name(menu.getMenu_name());
            menuList.setMenu_url(menu.getMenu_url());
            int j = menuListService.checkByUserAndMenuID(us.getUser_id(), menu.getMenu_id()).getList_id();
            if (j == 0) {
                menuList.setState(false);         //标记状态
            } else {
                menuList.setState(true);
            }
            menuWithIDAndStates.add(menuList);
        }
        if(menuWithIDAndStates.size() != 0){
            result.setSuccess();
            result.setData(menuWithIDAndStates);
            return result;
        }
        else{
            throw BusinessException.NO_DATA;
        }
        }

    /**
     *在登录时根据user_id得到该用户的menu清单
     */
    @PostMapping("/getMenuListByID")
    public BaseModelJson<List<MenuDetailWithID>> getMenuListByID(@RequestBody User us){

        BaseModelJson<List<MenuDetailWithID>> result = new BaseModelJson<>();
        List<MenuList> menus = menuListService.getListsByID(us.getUser_id());
        List<MenuDetailWithID> menuDetailWithIDS = new ArrayList<>();

        for (MenuList menuList : menus) {
            MenuDetailWithID menuDetailWithID = new MenuDetailWithID();
            Menu menu = menuService.getById(menuList.getMenu_id());
            menuDetailWithID.setMenu_id(menu.getMenu_id());
            menuDetailWithID.setMenu_icon(menu.getMenu_icon());
            menuDetailWithID.setMenu_name(menu.getMenu_name());
            menuDetailWithID.setMenu_url(menu.getMenu_url());
            menuDetailWithIDS.add(menuDetailWithID);
        }
        if(menuDetailWithIDS.size() != 0){
            result.setSuccess();
            result.setData(menuDetailWithIDS);
            return result;
        }
        else{
            throw BusinessException.NO_DATA;
        }
    }

    /**
     *用于在menuList里新增一个menuItem
     */
    @PostMapping("/addMenuList")
    public BaseModel addMenuList(@RequestBody MenuListItem menuListItem) {

        BaseModel result = new BaseModel();
        MenuList menuList = new MenuList(menuListItem.getUser_id(),menuListItem.getMenu_id());
        int i = menuListService.insert(menuList);
        if(i == 1){
            result.code = 200;
            return result;
        }else {
            throw BusinessException.INSERT_FAIL;
        }
    }

    /**
     *用于在menuList里删除一个menuItem
     */
    @PostMapping("/deleteMenuList")
    public BaseModel deleteMenuList(@RequestBody MenuListItem menuListItem) {

        BaseModel result = new BaseModel();
        int i = menuListService.deleteByTwoID(menuListItem.getUser_id(),menuListItem.getMenu_id());
        if(i == 1){
            result.code = 200;
            return result;
        }else {
            throw BusinessException.DELETE_FAIL;
        }
    }
}
