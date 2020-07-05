package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.packageInfo;

public interface packageInfoMapper {
    int insert(packageInfo record);

    int insertSelective(packageInfo record);
}