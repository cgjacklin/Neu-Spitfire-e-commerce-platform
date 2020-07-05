package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class walletTransactionAduit {
    private Integer transactionAuditId;

    private Integer buyerId;

    private Integer transactionId;

    private BigDecimal availableMoneyBefore;

    private BigDecimal depositingMoneyBefore;

    private BigDecimal withdrawingMoneyBefore;

    private BigDecimal operateMoney;

    private Byte operateType;

    private BigDecimal availableMoneyAfter;

    private BigDecimal depositingMoneyAfter;

    private BigDecimal withdrawingMoneyAfter;

    private String operateBy;

    private Byte status;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public walletTransactionAduit(Integer transactionAuditId, Integer buyerId, Integer transactionId, BigDecimal availableMoneyBefore, BigDecimal depositingMoneyBefore, BigDecimal withdrawingMoneyBefore, BigDecimal operateMoney, Byte operateType, BigDecimal availableMoneyAfter, BigDecimal depositingMoneyAfter, BigDecimal withdrawingMoneyAfter, String operateBy, Byte status, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime) {
        this.transactionAuditId = transactionAuditId;
        this.buyerId = buyerId;
        this.transactionId = transactionId;
        this.availableMoneyBefore = availableMoneyBefore;
        this.depositingMoneyBefore = depositingMoneyBefore;
        this.withdrawingMoneyBefore = withdrawingMoneyBefore;
        this.operateMoney = operateMoney;
        this.operateType = operateType;
        this.availableMoneyAfter = availableMoneyAfter;
        this.depositingMoneyAfter = depositingMoneyAfter;
        this.withdrawingMoneyAfter = withdrawingMoneyAfter;
        this.operateBy = operateBy;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
    }

    public walletTransactionAduit() {
        super();
    }

    public Integer getTransactionAuditId() {
        return transactionAuditId;
    }

    public void setTransactionAuditId(Integer transactionAuditId) {
        this.transactionAuditId = transactionAuditId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAvailableMoneyBefore() {
        return availableMoneyBefore;
    }

    public void setAvailableMoneyBefore(BigDecimal availableMoneyBefore) {
        this.availableMoneyBefore = availableMoneyBefore;
    }

    public BigDecimal getDepositingMoneyBefore() {
        return depositingMoneyBefore;
    }

    public void setDepositingMoneyBefore(BigDecimal depositingMoneyBefore) {
        this.depositingMoneyBefore = depositingMoneyBefore;
    }

    public BigDecimal getWithdrawingMoneyBefore() {
        return withdrawingMoneyBefore;
    }

    public void setWithdrawingMoneyBefore(BigDecimal withdrawingMoneyBefore) {
        this.withdrawingMoneyBefore = withdrawingMoneyBefore;
    }

    public BigDecimal getOperateMoney() {
        return operateMoney;
    }

    public void setOperateMoney(BigDecimal operateMoney) {
        this.operateMoney = operateMoney;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public BigDecimal getAvailableMoneyAfter() {
        return availableMoneyAfter;
    }

    public void setAvailableMoneyAfter(BigDecimal availableMoneyAfter) {
        this.availableMoneyAfter = availableMoneyAfter;
    }

    public BigDecimal getDepositingMoneyAfter() {
        return depositingMoneyAfter;
    }

    public void setDepositingMoneyAfter(BigDecimal depositingMoneyAfter) {
        this.depositingMoneyAfter = depositingMoneyAfter;
    }

    public BigDecimal getWithdrawingMoneyAfter() {
        return withdrawingMoneyAfter;
    }

    public void setWithdrawingMoneyAfter(BigDecimal withdrawingMoneyAfter) {
        this.withdrawingMoneyAfter = withdrawingMoneyAfter;
    }

    public String getOperateBy() {
        return operateBy;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy == null ? null : operateBy.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}