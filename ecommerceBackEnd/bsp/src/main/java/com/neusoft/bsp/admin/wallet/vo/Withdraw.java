package com.neusoft.bsp.admin.wallet.vo;

import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;

public class Withdraw implements BaseEntity<Integer> {
    int user_id;
    BigDecimal withdraw_money;
    String password;

    public BigDecimal getWithdraw_money() {
        return withdraw_money;
    }

    public void setWithdraw_money(BigDecimal withdraw_money) {
        this.withdraw_money = withdraw_money;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

