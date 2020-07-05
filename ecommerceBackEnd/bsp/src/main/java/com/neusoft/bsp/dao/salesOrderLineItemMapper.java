package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.salesOrderLineItem;

public interface salesOrderLineItemMapper {
    int insert(salesOrderLineItem record);

    int insertSelective(salesOrderLineItem record);
}