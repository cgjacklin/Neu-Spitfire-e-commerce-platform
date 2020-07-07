package com.neusoft.bsp.business.bvo.service.impl;

import com.neusoft.bsp.business.bvo.mapper.WishlistMapper;
import com.neusoft.bsp.business.bvo.service.WishlistService;
import com.neusoft.bsp.business.po.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("WithlistService")
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    WishlistMapper wishlistMapper;

    @Override
    public int delete(Integer wit_id) {
        return wishlistMapper.delete(wit_id);
    }

    @Override
    public int insert(Wishlist wishlist) {
        return wishlistMapper.insert(wishlist);
    }

    @Override
    public List<Wishlist> getAllById(Integer dsr_id) {
        return wishlistMapper.getAllById(dsr_id);
    }

    @Override
    public int update(Wishlist wishlist) {
        return wishlistMapper.update(wishlist);
    }

    @Override
    public Wishlist getById(Integer wit_id) {
        return wishlistMapper.getById(wit_id);
    }
}
