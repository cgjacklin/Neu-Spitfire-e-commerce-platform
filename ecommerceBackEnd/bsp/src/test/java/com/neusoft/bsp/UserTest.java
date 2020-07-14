package com.neusoft.bsp;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.DictionaryController;
import com.neusoft.bsp.controller.UserController;
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
class UserTest {

    @Autowired
    UserController userController;

//Test login
    @Test
    void TestLogin_success() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("1");

        BaseModelJson<Map<String, String>> bmj = userController.getAllByFilter(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void TestLogin_wrongPassword() {
        User user=new User();
        user.setUsername("1");
        user.setPassword("b");
        assertThrows(BusinessException.class, () -> {
            BaseModelJson<Map<String, String>> bmj = userController.getAllByFilter(user);

        });
    }

    @Test
    void TestLogin_noUser() {
        User user=new User();
        user.setUsername("h");
        user.setPassword("b");
        assertThrows(BusinessException.class, () -> {
            BaseModelJson<Map<String, String>> bmj = userController.getAllByFilter(user);
        });
    }


//test register

    @Test
    void TestRegister_MVOsuccess() {
        User user=new User();
        user.setUsername("4");
        user.setPassword("4");
        user.setRole_id("1");
        BaseModel bmj = userController.register(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void TestRegister_BVOsuccess() {
        User user=new User();
        user.setUsername("5");
        user.setPassword("5");
        user.setRole_id("2");
        BaseModel bm = userController.register(user);
        assertEquals(200, bm.code);
    }

    @Test
    void TestRegister_sameUsername() {
        User user=new User();
        user.setUsername("5");
        user.setPassword("5");
        user.setRole_id("2");
        assertThrows(BusinessException.class, () -> {
            BaseModel bm = userController.register(user);
        });
    }



}
