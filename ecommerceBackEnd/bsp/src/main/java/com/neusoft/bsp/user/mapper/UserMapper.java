package com.neusoft.bsp.user.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Integer, User> {
    public User getByUsername(String username);

}
