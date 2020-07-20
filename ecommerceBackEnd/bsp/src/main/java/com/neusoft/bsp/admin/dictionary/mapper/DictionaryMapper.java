package com.neusoft.bsp.admin.dictionary.mapper;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

//@CacheConfig(cacheNames="dictionaryCache")
@Repository
public interface DictionaryMapper extends BaseMapper<Integer, Dictionary> {

}
