package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.common.base.BaseEntity;

public class OrderRequest implements BaseEntity<Integer> {
    int user_id;
    String sts_cd;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "user_id=" + user_id +
                ", sts_cd='" + sts_cd + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }
}
