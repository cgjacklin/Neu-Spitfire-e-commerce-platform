package com.neusoft.bsp.admin.parameter.mapper;

import com.neusoft.bsp.admin.parameter.po.Parameter;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

//@CacheConfig(cacheNames="parameterCache")
@Repository
public interface ParameterMapper extends BaseMapper<Integer, Parameter> {

}
