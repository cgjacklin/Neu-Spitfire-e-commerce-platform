package com.neusoft.bsp.model;

import java.util.Date;

public class walletAccount {
    private Integer buyerId;

    private String accountName;

    private String email;

    private String password;

    private Date activeTime;

    private String isActive;

    private Byte status;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Integer accountType;

    private String holdOrderTime;

    private String autoPayStatus;

    public walletAccount(Integer buyerId, String accountName, String email, String password, Date activeTime, String isActive, Byte status, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, Integer accountType, String holdOrderTime, String autoPayStatus) {
        this.buyerId = buyerId;
        this.accountName = accountName;
        this.email = email;
        this.password = password;
        this.activeTime = activeTime;
        this.isActive = isActive;
        this.status = status;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.accountType = accountType;
        this.holdOrderTime = holdOrderTime;
        this.autoPayStatus = autoPayStatus;
    }

    public walletAccount() {
        super();
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
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

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getHoldOrderTime() {
        return holdOrderTime;
    }

    public void setHoldOrderTime(String holdOrderTime) {
        this.holdOrderTime = holdOrderTime == null ? null : holdOrderTime.trim();
    }

    public String getAutoPayStatus() {
        return autoPayStatus;
    }

    public void setAutoPayStatus(String autoPayStatus) {
        this.autoPayStatus = autoPayStatus == null ? null : autoPayStatus.trim();
    }
}