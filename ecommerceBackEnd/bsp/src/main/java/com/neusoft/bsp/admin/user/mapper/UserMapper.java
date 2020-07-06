package com.neusoft.bsp.admin.user.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.admin.user.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Integer, User> {
    public User getByUsername(String username);

}
