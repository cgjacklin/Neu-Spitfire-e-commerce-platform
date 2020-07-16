package com.neusoft.bsp.admin.menu.service.impl;


import com.neusoft.bsp.admin.menu.mapper.MenuListMapper;
import com.neusoft.bsp.admin.menu.po.MenuList;
import com.neusoft.bsp.admin.menu.service.MenuListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuListService")
public class MenuListServiceImpl implements MenuListService {

    @Autowired
    MenuListMapper menuListMapper;

    @Override
    public int insert(MenuList menuList) {
        return menuListMapper.insert(menuList);
    }

//    @Override
//    public int update(MenuList menuList) {
//        return menuListMapper.update(menuList);
//    }


    @Override
    public int deleteByTwoID(int user_id, int menu_id) {
        return menuListMapper.deleteByTwoID(user_id,menu_id);
    }

    @Override
    public MenuList checkByUserAndMenuID(int user_id, int menu_id) {
        return menuListMapper.checkByUserAndMenuID(user_id,menu_id);
    }

    @Override
    public List<MenuList> getListsByID(int user_id) {
        return menuListMapper.getListsByID(user_id);
    }

    //    @Override
//    public MenuList getById(int list_id) {
//        return menuListMapper.getById(list_id);
//    }
}
