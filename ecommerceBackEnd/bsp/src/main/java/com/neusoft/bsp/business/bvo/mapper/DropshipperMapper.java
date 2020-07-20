package com.neusoft.bsp.business.bvo.mapper;

import com.neusoft.bsp.business.po.Dropshipper;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

//@CacheConfig(cacheNames="dropshipperCache")
@Repository
public interface DropshipperMapper extends BaseMapper<Integer,Dropshipper> {

}
