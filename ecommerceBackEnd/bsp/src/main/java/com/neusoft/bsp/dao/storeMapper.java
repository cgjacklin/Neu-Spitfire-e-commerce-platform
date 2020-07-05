package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.store;

public interface storeMapper {
    int insert(store record);

    int insertSelective(store record);
}