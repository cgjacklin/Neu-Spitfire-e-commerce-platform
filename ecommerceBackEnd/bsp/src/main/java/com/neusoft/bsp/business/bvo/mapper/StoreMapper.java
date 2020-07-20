package com.neusoft.bsp.business.bvo.mapper;

import com.neusoft.bsp.business.po.Store;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="storeCache")
@Repository
public interface StoreMapper extends BaseMapper<Integer, Store> {
//    @Cacheable()
    List<Store> getAllByDsrId(int dsr_id);
}
