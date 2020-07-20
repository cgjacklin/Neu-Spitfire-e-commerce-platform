package com.neusoft.bsp.admin.menu.mapper;

import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="menuCache")
@Repository
public interface MenuMapper extends BaseMapper<Integer, Menu> {
//    @CachePut()
    List<Menu> getAll();
}
