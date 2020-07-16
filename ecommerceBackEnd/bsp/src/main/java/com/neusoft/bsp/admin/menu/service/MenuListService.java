package com.neusoft.bsp.admin.menu.service;

import com.neusoft.bsp.admin.menu.po.Menu;
import com.neusoft.bsp.admin.menu.po.MenuList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuListService {
    int insert(MenuList menuList);

//    int update(MenuList menuList);
    int deleteByTwoID(int user_id, int menu_id);

    MenuList checkByUserAndMenuID(int user_id, int menu_id);

    List<MenuList> getListsByID(int user_id);
//    MenuList getById(int list_id);
}
