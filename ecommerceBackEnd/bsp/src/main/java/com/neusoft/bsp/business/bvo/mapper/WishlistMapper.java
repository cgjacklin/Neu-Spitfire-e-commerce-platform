package com.neusoft.bsp.business.bvo.mapper;

import com.neusoft.bsp.business.po.Wishlist;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;


import java.util.List;

@CacheConfig(cacheNames="wishlistCache")
@Repository
public interface WishlistMapper extends BaseMapper<Integer, Wishlist> {
    @Cacheable()
    List<Wishlist> getAllById(Integer dsr_id);
}
