package com.neusoft.bsp.admin.menu.po;

import com.neusoft.bsp.common.base.BaseEntity;

public class MenuList implements BaseEntity<Integer> {
    int list_id;
    int user_id;
    int menu_id;

    public MenuList(){}
    public MenuList(int user_id, int menu_id) {
        this.user_id = user_id;
        this.menu_id = menu_id;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
