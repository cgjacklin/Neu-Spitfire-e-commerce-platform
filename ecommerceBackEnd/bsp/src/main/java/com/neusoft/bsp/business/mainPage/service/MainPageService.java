package com.neusoft.bsp.business.mainPage.service;

import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.admin.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public interface MainPageService {
    HashMap<String, Object> getInfo(User user);
    User getUserBasicInfo(User user);
}
