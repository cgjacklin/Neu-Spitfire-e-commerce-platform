package com.neusoft.bsp.business.vo;

public class StoreWithUserAndStr {

    int user_id;
    int str_id;
    String store_sts_cd;
    String store_name;
    String plataeform_type;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public String getStore_sts_cd() {
        return store_sts_cd;
    }

    public void setStore_sts_cd(String store_sts_cd) {
        this.store_sts_cd = store_sts_cd;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPlataeform_type() {
        return plataeform_type;
    }

    public void setPlataeform_type(String plataeform_type) {
        this.plataeform_type = plataeform_type;
    }
}
