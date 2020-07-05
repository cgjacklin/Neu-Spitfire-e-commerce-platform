package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class walletAccountFund {
    private Integer buyerId;

    private BigDecimal availableMoney;

    private BigDecimal depositingMoney;

    private BigDecimal withdrawingMoney;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String currency;

    public walletAccountFund(Integer buyerId, BigDecimal availableMoney, BigDecimal depositingMoney, BigDecimal withdrawingMoney, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, String currency) {
        this.buyerId = buyerId;
        this.availableMoney = availableMoney;
        this.depositingMoney = depositingMoney;
        this.withdrawingMoney = withdrawingMoney;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.currency = currency;
    }

    public walletAccountFund() {
        super();
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }

    public BigDecimal getDepositingMoney() {
        return depositingMoney;
    }

    public void setDepositingMoney(BigDecimal depositingMoney) {
        this.depositingMoney = depositingMoney;
    }

    public BigDecimal getWithdrawingMoney() {
        return withdrawingMoney;
    }

    public void setWithdrawingMoney(BigDecimal withdrawingMoney) {
        this.withdrawingMoney = withdrawingMoney;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }
}