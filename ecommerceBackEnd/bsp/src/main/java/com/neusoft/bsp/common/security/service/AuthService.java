package com.neusoft.bsp.common.security.service;

import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.user.entity.User;

public interface AuthService {
    String login(User user);
}
