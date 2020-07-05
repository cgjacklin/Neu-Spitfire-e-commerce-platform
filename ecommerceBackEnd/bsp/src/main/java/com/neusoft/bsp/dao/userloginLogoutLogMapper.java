package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.userloginLogoutLog;

public interface userloginLogoutLogMapper {
    int insert(userloginLogoutLog record);

    int insertSelective(userloginLogoutLog record);
}