package com.neusoft.bsp;

import com.neusoft.bsp.admin.menu.mapper.MenuMapper;
import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.service.MenuService;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.controller.WishlistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BspApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MenuService menuService;

    @Autowired
    WishlistController wishlistController;

    @Autowired
    WishlistService wishlistService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.getAll();
        System.out.println(users+"!!!!!!!!!!!!!!!!!!1");
    }

    @Test
    void getMenuTest(){
        List<Menu> menus = menuService.getAll();
        System.out.println(menus);
    }

    @Test
    public void TestgetWishlist_success(){
        int user_id = 1;
        BaseModelJson<Map<String, Object>> bmj= wishlistController.getWishlist(user_id);
        System.out.println(bmj);
        assertEquals(200, bmj.code);

    }

}
