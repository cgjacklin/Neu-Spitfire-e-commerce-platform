package com.neusoft.bsp.common.security.service.impl;

import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.admin.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(BusinessException.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

          User user = userService.getByUserName(s);
//          logger.info(user.getName());
//          return JwtUserFactory.create(user);
//        return new User("foo", "foo",
//                new ArrayList<>());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}