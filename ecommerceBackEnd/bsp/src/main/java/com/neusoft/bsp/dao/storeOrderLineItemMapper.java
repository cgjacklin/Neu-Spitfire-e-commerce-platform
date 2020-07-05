package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.storeOrderLineItem;

public interface storeOrderLineItemMapper {
    int insert(storeOrderLineItem record);

    int insertSelective(storeOrderLineItem record);
}