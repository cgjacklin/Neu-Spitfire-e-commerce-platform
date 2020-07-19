package com.neusoft.bsp;

import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.vo.MenuDetailWithID;
import com.neusoft.bsp.admin.menu.vo.MenuListItem;
import com.neusoft.bsp.admin.menu.vo.MenuWithIDAndState;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.MenuListController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
 class MenuListTest {
    @Autowired
    MenuListController menuListController;

    @Test
    void getAllMenusWithState_success() {
        User user =new User();
        user.setUser_id(3);
        BaseModelJson<List<MenuWithIDAndState>> bmj = menuListController.getAllMenusWithState(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void getMenuListByID_success() {
        User user =new User();
        user.setUser_id(3);
        BaseModelJson<List<MenuDetailWithID>> bmj = menuListController.getMenuListByID(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void getMenuListByID_nouser() {
        User user =new User();
        user.setUser_id(88);

        assertThrows(BusinessException.class, () -> {
            BaseModelJson<List<MenuDetailWithID>> bmj = menuListController.getMenuListByID(user);
        });
    }

    @Test
    void addMenuList_success() {
        MenuListItem menuListItem =new MenuListItem();
        menuListItem.setUser_id(20);
        menuListItem.setMenu_id(1);
        BaseModel bmj = menuListController.addMenuList(menuListItem);
        assertEquals(200, bmj.code);
    }

    @Test
    void deleteMenuList_success() {
        MenuListItem menuListItem =new MenuListItem();
        menuListItem.setUser_id(20);
        menuListItem.setMenu_id(1);
        BaseModel bmj = menuListController.deleteMenuList(menuListItem);
        assertEquals(200, bmj.code);
    }



}
