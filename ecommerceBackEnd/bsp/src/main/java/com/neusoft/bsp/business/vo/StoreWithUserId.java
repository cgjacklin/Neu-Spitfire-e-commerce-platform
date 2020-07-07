package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.common.base.BaseEntity;

public class StoreWithUserId implements BaseEntity<Integer> {

    int user_id;
    String plataeform_type;
    String store_name;
    String store_sts_cd;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPlataeform_type() {
        return plataeform_type;
    }

    public void setPlataeform_type(String plataeform_type) {
        this.plataeform_type = plataeform_type;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_sts_cd() {
        return store_sts_cd;
    }

    public void setStore_sts_cd(String store_sts_cd) {
        this.store_sts_cd = store_sts_cd;
    }
}
