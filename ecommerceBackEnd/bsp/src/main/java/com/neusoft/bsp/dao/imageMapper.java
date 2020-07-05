package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.image;

public interface imageMapper {
    int insert(image record);

    int insertSelective(image record);
}