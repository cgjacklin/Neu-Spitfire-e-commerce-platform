package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.business.po.Brand;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="brandCache")
@Repository
public interface BrandMapper extends BaseMapper<Integer, Brand> {
//    @Cacheable()
    List<Brand> getAllById(Integer man_id);

}
