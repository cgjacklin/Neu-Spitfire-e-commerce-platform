package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.vo.UserIdAndDeleteId;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.RoleController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
public class RoleTest {

@Autowired
    RoleController roleController;

    @Test
    void TestgetUser_success() {
        int user_id = 1;
        BaseModelJson<Map<String, Object>> bmj = roleController.getUsers(user_id);
        assertEquals(200, bmj.code);
    }

    @Test
    void TestgetUser_user_not_exist() {
        assertThrows(BusinessException.class, () -> {
            int user_id = 10;
            BaseModelJson<Map<String, Object>> bmj = roleController.getUsers(user_id);
        });
    }

    @Test
    void TestgetUser_permission_deny() {
        assertThrows(BusinessException.class, () -> {
            int user_id = 2;
            BaseModelJson<Map<String, Object>> bmj = roleController.getUsers(user_id);
        });
    }

    @Test
    public void TestdeleteWishlist_success(){
        UserIdAndDeleteId uad = new UserIdAndDeleteId();
        uad.setUser_id(1);
        uad.setDelete_id(2);
        BaseModel bm = roleController.deletedUser(uad);
        assertEquals(200, bm.code);
    }


}
