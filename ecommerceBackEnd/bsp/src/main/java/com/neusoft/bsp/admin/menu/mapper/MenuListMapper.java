package com.neusoft.bsp.admin.menu.mapper;

import com.neusoft.bsp.admin.menu.po.MenuList;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

//@CacheConfig(cacheNames="menuListCache")
@Repository
public interface MenuListMapper extends BaseMapper<Integer, MenuList> {
//    @Cacheable()
    MenuList checkByUserAndMenuID(int user_id, int menu_id);

//    @Cacheable()
    List<MenuList> getListsByID(int user_id);

//    @CacheEvict(allEntries = true, beforeInvocation = true)
    int deleteByTwoID(int user_id, int menu_id);
}
