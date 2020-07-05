package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.productDescrition;

public interface productDescritionMapper {
    int insert(productDescrition record);

    int insertSelective(productDescrition record);
}