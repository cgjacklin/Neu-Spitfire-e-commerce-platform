package com.neusoft.bsp.admin.menu.service;

import com.neusoft.bsp.admin.menu.po.Menu;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface MenuService {

//    int insert(Menu menu);

    int update(Menu menu);

//    int delete(int menu_id);

    Menu getById(int menu_id);

    List<Menu> getAll();
}
