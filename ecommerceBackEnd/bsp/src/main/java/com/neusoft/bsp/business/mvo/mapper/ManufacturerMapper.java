package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.business.po.Manufacturer;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames="manufacturerCache")
@Repository
public interface ManufacturerMapper extends BaseMapper<Integer, Manufacturer> {
    @CachePut()
    int updateUserWithLastManu(int user_id);

    @CachePut
    int updateUserWithManuID(int man_id);
}
