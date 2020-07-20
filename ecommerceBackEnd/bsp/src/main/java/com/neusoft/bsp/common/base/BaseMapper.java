package com.neusoft.bsp.common.base;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

//@CacheConfig(cacheNames="baseCache")
public interface BaseMapper<S,T> {
//    @CachePut()
    int insert(T t);

//    @CachePut()
    int update(T t);

//    @CacheEvict(allEntries = true, beforeInvocation = true)
    int delete(S pk);

//    @Cacheable()
    T getById(S pk);

//    @Cacheable()
    List<T> getAll();

//    @Cacheable()
    List<T> getAllByFilter(Map<String,Object> map);

}
