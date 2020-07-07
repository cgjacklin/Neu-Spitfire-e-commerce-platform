package com.neusoft.bsp.business.bvo.mapper;

import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WishlistMapper extends BaseMapper<Integer, Wishlist> {
    List<Wishlist> getAllById(Integer dsr_id);
}
