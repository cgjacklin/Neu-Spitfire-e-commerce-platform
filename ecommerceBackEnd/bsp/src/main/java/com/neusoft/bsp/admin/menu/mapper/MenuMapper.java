package com.neusoft.bsp.admin.menu.mapper;

import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper extends BaseMapper<Integer, Menu> {
    List<Menu> getAll();
}
