package com.neusoft.bsp.admin.wallet.po;

import com.neusoft.bsp.common.base.BaseEntity;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class WalletAccountFund implements BaseEntity<Integer> {

    int buyer_id;
    BigDecimal available_money ;
    BigDecimal depositing_money;
    BigDecimal withdrawing_money;
    String create_by;
    Timestamp create_time;
    String last_update_by;
    Timestamp last_update_time;
    String currency;

    public WalletAccountFund() {

    }

    public WalletAccountFund(int buyer_id, BigDecimal available_money, BigDecimal depositing_money, BigDecimal withdrawing_money, String create_by, Timestamp create_time, String last_update_by, Timestamp last_update_time, String currency) {
        this.buyer_id = buyer_id;
        this.available_money = available_money;
        this.depositing_money = depositing_money;
        this.withdrawing_money = withdrawing_money;
        this.create_by = create_by;
        this.create_time = create_time;
        this.last_update_by = last_update_by;
        this.last_update_time = last_update_time;
        this.currency = currency;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public BigDecimal getAvailable_money() {
        return available_money;
    }

    public void setAvailable_money(BigDecimal available_money) {
        this.available_money = available_money;
    }

    public BigDecimal getDepositing_money() {
        return depositing_money;
    }

    public void setDepositing_money(BigDecimal depositing_money) {
        this.depositing_money = depositing_money;
    }

    public BigDecimal getWithdrawing_money() {
        return withdrawing_money;
    }

    public void setWithdrawing_money(BigDecimal withdrawing_money) {
        this.withdrawing_money = withdrawing_money;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public Timestamp getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Timestamp last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
