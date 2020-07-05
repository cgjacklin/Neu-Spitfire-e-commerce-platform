package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.storeOrder;

public interface storeOrderMapper {
    int insert(storeOrder record);

    int insertSelective(storeOrder record);
}