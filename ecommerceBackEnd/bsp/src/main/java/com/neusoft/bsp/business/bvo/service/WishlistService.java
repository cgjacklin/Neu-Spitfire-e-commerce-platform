package com.neusoft.bsp.business.bvo.service;

import com.neusoft.bsp.business.po.Wishlist;

import java.util.List;

public interface WishlistService {
    int delete(Integer wit_id);

    int insert(Wishlist wishlist);

    List<Wishlist> getAllById(Integer dsr_id);

    int update(Wishlist wishlist);

    Wishlist getById(Integer wit_id);
}
