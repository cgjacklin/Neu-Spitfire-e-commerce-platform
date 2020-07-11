package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.business.po.Product;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@CacheConfig(cacheNames="productCache")
@Repository
public interface ProductMapper extends BaseMapper<Integer, Product> {
    @CachePut()
    int updateSts(Product product);

    @Cacheable()
    List<Product> getProductOnShelf();
}
