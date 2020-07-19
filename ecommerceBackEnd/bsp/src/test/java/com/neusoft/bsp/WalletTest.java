package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.controller.WalletController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
class WalletTest {

    @Autowired
    WalletController walletController;

    @Test
    void getRecord_success() {
        User user=new User();
        user.setUser_id(1);

        BaseModelJson<Map<String, Object>> bmj = walletController.getRecord(user);

        assertEquals(200, bmj.code);
    }
}
