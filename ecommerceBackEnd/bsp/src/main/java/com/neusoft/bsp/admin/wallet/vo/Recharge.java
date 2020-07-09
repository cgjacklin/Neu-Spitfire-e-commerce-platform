package com.neusoft.bsp.admin.wallet.vo;

import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;

public class Recharge implements BaseEntity<Integer> {
    int user_id;
    BigDecimal depositing_money;
    String password;

    public Recharge(int user_id, BigDecimal depositing_money, String password) {
        this.user_id = user_id;
        this.depositing_money = depositing_money;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getDepositing_money() {
        return depositing_money;
    }

    public void setDepositing_money(BigDecimal depositing_money) {
        this.depositing_money = depositing_money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
