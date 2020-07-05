package com.neusoft.bsp.model;

import java.util.Date;

public class store {
    private Integer strId;

    private Integer dsrId;

    private String plataeformType;

    private String storeName;

    private String storeStsCd;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String stsCd;

    private String remark;

    public store(Integer strId, Integer dsrId, String plataeformType, String storeName, String storeStsCd, String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String stsCd, String remark) {
        this.strId = strId;
        this.dsrId = dsrId;
        this.plataeformType = plataeformType;
        this.storeName = storeName;
        this.storeStsCd = storeStsCd;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.stsCd = stsCd;
        this.remark = remark;
    }

    public store() {
        super();
    }

    public Integer getStrId() {
        return strId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public Integer getDsrId() {
        return dsrId;
    }

    public void setDsrId(Integer dsrId) {
        this.dsrId = dsrId;
    }

    public String getPlataeformType() {
        return plataeformType;
    }

    public void setPlataeformType(String plataeformType) {
        this.plataeformType = plataeformType == null ? null : plataeformType.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreStsCd() {
        return storeStsCd;
    }

    public void setStoreStsCd(String storeStsCd) {
        this.storeStsCd = storeStsCd == null ? null : storeStsCd.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd == null ? null : stsCd.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}