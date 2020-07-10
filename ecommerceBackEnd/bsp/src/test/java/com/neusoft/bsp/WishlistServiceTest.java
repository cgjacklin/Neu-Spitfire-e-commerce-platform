package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.business.vo.UserIdAndProId;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.controller.WishlistController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =BspApplication.class)
class WishlistServiceTest {

//    @Autowired
//    UserMapper userMapper;
//
//    @Autowired
//    WishlistController wishlistController;
//
//    @Autowired
//    WishlistService wishlistService;
//
//
//    @Test
//    void TestgetWishlist_success() {
//        int user_id = 1;
//        BaseModelJson<Map<String, Object>> bmj = wishlistController.getWishlist(user_id);
//        System.out.println(bmj);
//        assertEquals(200, bmj.code);
//
//    }
//
//    @Test
//    public void TestgetWishlist_user_not_exist() {
//            assertThrows(BusinessException.class, () -> {
//        int user_id = 10;
//        BaseModelJson<Map<String, Object>> bmj = wishlistController.getWishlist(user_id);
//                    });
////    }
//    }
//
//
//    @Test
//    public void TestaddWishlist_success() {
//        UserIdAndProId uap = new UserIdAndProId();
//        uap.setPro_id(1);
//        uap.setUser_id(1);
//        BaseModel bm = wishlistController.addWishlist(uap,null);
//        assertEquals(200, bm.code);
//    }
//
//    @Test
//    public void TestaddWishlist_user_not_exist() {
//        assertThrows(BusinessException.class, () -> {
//        UserIdAndProId uap = new UserIdAndProId();
//        uap.setPro_id(1);
//        uap.setUser_id(10);
//        BaseModel bm = wishlistController.addWishlist(uap,null);
//        });
//    }
//
//    @Test
//    public void TestaddWishlist_pro_not_exist() {
//        assertThrows(BusinessException.class, () -> {
//            UserIdAndProId uap = new UserIdAndProId();
//            uap.setPro_id(10);
//            uap.setUser_id(1);
//            BaseModel bm = wishlistController.addWishlist(uap,null);
//        });
//    }
//
//    @Test
//    public void TestdeleteWishlist_success(){
//        int wit_id = 1;
//        BaseModel bm = wishlistController.deletedWishlist(1);
//        assertEquals(200, bm.code);
//    }
//
//    @Test
//    public void TestdeleteWishlist_wit_not_exist(){
//        assertThrows(BusinessException.class, () -> {
//        int wit_id = 10;
//        BaseModel bm = wishlistController.deletedWishlist(1);
//        });
//    }


}