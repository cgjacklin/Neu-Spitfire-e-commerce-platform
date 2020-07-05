package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.product;

public interface productMapper {
    int insert(product record);

    int insertSelective(product record);
}