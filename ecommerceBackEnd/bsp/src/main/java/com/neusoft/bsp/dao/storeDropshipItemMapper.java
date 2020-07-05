package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.storeDropshipItem;

public interface storeDropshipItemMapper {
    int insert(storeDropshipItem record);

    int insertSelective(storeDropshipItem record);
}