package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.shippingAddress;

public interface shippingAddressMapper {
    int insert(shippingAddress record);

    int insertSelective(shippingAddress record);
}