package com.neusoft.bsp.common.security.service;

import com.neusoft.bsp.admin.user.po.User;

public interface AuthService {
    String login(User user);
}
