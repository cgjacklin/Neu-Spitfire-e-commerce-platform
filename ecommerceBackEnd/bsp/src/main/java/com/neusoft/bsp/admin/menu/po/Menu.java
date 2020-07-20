package com.neusoft.bsp.admin.menu.po;

import com.neusoft.bsp.common.base.BaseEntity;

public class Menu implements BaseEntity<Integer> {
    int menu_id;
    String menu_name;
    String menu_url;
    String parent_id;
    String menu_order;
    String menu_icon;
    String menu_type;

    public Menu(){}
    public Menu(int menu_id, String menu_name) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(String menu_order) {
        this.menu_order = menu_order;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }
}
