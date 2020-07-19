package com.neusoft.bsp;

import com.neusoft.bsp.admin.menu.vo.MenuDetailWithID;
import com.neusoft.bsp.admin.menu.vo.MenuWithIDAndState;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.MVOInfoController;
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
 class MVOInfoTest {
    @Autowired
    MVOInfoController mvoInfoController;

    @Test
    void getManufacturerByUserID_success() {
        User user =new User();
        user.setUser_id(1);
        BaseModelJson<Manufacturer> bmj = mvoInfoController.getManufacturerByUserID(user);
        assertEquals(200, bmj.code);
    }

    @Test
    void getManufacturerByUserID_noUser() {
        User user =new User();
        user.setUser_id(88);
        assertThrows(BusinessException.class, () -> {
            BaseModelJson<Manufacturer> bmj = mvoInfoController.getManufacturerByUserID(user);
        });

    }

}
