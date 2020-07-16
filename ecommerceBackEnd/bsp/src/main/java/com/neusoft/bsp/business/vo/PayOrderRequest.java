package com.neusoft.bsp.business.vo;

import java.math.BigDecimal;

public class PayOrderRequest extends OrderRequest{
    int or_id;
    String password;
    BigDecimal paid_money;

    @Override
    public String toString() {
        return "PayOrderRequest{" +
                "user_id=" + user_id +
                ", or_id=" + or_id +
                ", password='" + password + '\'' +
                ", paid_money=" + paid_money +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getPaid_money() {
        return paid_money;
    }

    public void setPaid_money(BigDecimal paid_money) {
        this.paid_money = paid_money;
    }
}
