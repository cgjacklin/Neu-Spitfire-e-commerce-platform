package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.offerPrice;

public interface offerPriceMapper {
    int insert(offerPrice record);

    int insertSelective(offerPrice record);
}