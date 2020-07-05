package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.parameter;

public interface parameterMapper {
    int insert(parameter record);

    int insertSelective(parameter record);
}