package com.neusoft.bsp.common.security.service.impl;

import com.neusoft.bsp.common.security.model.JwtUser;
import com.neusoft.bsp.admin.user.po.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        System.out.println("username "+user.getUsername());
        System.out.println("password "+user.getPassword());
        return new JwtUser(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
