package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.dropshipPrice;

public interface dropshipPriceMapper {
    int insert(dropshipPrice record);

    int insertSelective(dropshipPrice record);
}