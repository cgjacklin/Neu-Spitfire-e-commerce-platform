package com.neusoft.bsp;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.vo.MenuWithUserID;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.MenuController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
class MenuTest {
    @Autowired
    MenuController menuController;

    BindingResult bindingResult;
    @Test
    void TestgetMenu_success() {
        User user =new User();
        user.setUser_id(3);
        BaseModelJson<List<Menu>> bmj = menuController.getAllMenuList(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void TestgetMenu_noright() {
        User user =new User();
        user.setUser_id(1);
        assertThrows(BusinessException.class, () -> {
            BaseModelJson<List<Menu>> bmj = menuController.getAllMenuList(user);

        });
    }

    @Test
    void TestupdateMenuInfo_noright() {

        MenuWithUserID menuWithUserID =new MenuWithUserID();
        menuWithUserID.setUser_id(1);
        menuWithUserID.setMenu_id(1);
        menuWithUserID.setMenu_name("compony Information");

        BaseModel bmj = menuController.updateMenuInfo(menuWithUserID,null);
        assertEquals(200, bmj.code);
    }
}
