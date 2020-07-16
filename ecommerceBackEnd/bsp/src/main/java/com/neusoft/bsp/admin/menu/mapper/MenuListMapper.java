package com.neusoft.bsp.admin.menu.mapper;

import com.neusoft.bsp.admin.menu.po.MenuList;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@CacheConfig(cacheNames="menuListCache")
@Repository
public interface MenuListMapper extends BaseMapper<Integer, MenuList> {
    MenuList checkByUserAndMenuID(int user_id, int menu_id);

    List<MenuList> getListsByID(int user_id);

    int deleteByTwoID(int user_id, int menu_id);
}
