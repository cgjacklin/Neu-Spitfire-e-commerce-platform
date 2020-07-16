package com.neusoft.bsp.business.vo;

public class CancelOrderRequest extends OrderRequest{
    int or_id;

    @Override
    public String toString() {
        return "CancelOrderRequest{" +
                "or_id=" + or_id +
                ", user_id=" + user_id +
                ", sts_cd='" + sts_cd + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOr_id() {
        return or_id;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }
}
