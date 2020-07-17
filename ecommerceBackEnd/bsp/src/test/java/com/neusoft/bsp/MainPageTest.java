package com.neusoft.bsp;


import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.MainPageController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
class MainPageTest {
    @Autowired
    MainPageController  mainPageController;

    @Test
    void test_getInfo_success() {
        User user=new User();
        user.setUser_id(1);
        BaseModelJson<Map<String, Object>> bmj = mainPageController.getInfo(user);
        assertEquals(200, bmj.code);
    }


    @Test
    void test_getInfo_noUser() {
        User user=new User();
        user.setUser_id(17);
        assertThrows(Exception.class, () -> {
            BaseModelJson<Map<String, Object>> bmj = mainPageController.getInfo(user);
        });
    }

    @Test
    void test_getUserBasicInfo_success() {
        User user=new User();
        user.setUser_id(1);
        BaseModelJson<User> bmj = mainPageController.getUserBasicInfo(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void test_getUserBasicInfo_noUser() {
        User user=new User();
        user.setUser_id(17);
        BaseModelJson<User> bmj = mainPageController.getUserBasicInfo(user);
        assertEquals(200, bmj.code);

    }

}
