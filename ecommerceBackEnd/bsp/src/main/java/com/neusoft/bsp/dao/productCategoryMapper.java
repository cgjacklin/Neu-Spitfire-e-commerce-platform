package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.productCategory;

public interface productCategoryMapper {
    int insert(productCategory record);

    int insertSelective(productCategory record);
}