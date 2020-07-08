package com.neusoft.bsp.admin.menu.service.impl;

import com.neusoft.bsp.admin.menu.mapper.MenuMapper;
import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    @Override
    public Menu getById(int menu_id) {
        return menuMapper.getById(menu_id);
    }

    @Override
    public List<Menu> getAll() {
        return menuMapper.getAll();
    }
}
