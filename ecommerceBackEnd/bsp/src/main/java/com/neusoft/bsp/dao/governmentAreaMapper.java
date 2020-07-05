package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.governmentArea;

public interface governmentAreaMapper {
    int insert(governmentArea record);

    int insertSelective(governmentArea record);
}