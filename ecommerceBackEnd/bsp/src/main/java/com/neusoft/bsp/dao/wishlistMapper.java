package com.neusoft.bsp.dao;

import com.neusoft.bsp.model.wishlist;

public interface wishlistMapper {
    int insert(wishlist record);

    int insertSelective(wishlist record);
}