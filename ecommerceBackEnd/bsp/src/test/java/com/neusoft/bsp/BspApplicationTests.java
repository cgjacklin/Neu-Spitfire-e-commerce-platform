package com.neusoft.bsp;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BspApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.getAll();
        System.out.println(users+"!!!!!!!!!!!!!!!!!!1");
    }

}
