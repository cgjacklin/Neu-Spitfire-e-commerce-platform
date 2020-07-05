package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class storeDropshipItem {
    private Integer dilId;

    private Integer proId;

    private Integer strId;

    private Integer storeRetention;

    private BigDecimal dropshipPrice;

    private String dropshipStatus;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Integer callCnt;

    private Date lastUpdateDate;

    private String remark;

    private String stsCd;

    private Integer shelfStock;

    private Date preferDate;

    public storeDropshipItem(Integer dilId, Integer proId, Integer strId, Integer storeRetention, BigDecimal dropshipPrice, String dropshipStatus, String createdBy, Date creationDate, String lastUpdateBy, Integer callCnt, Date lastUpdateDate, String remark, String stsCd, Integer shelfStock, Date preferDate) {
        this.dilId = dilId;
        this.proId = proId;
        this.strId = strId;
        this.storeRetention = storeRetention;
        this.dropshipPrice = dropshipPrice;
        this.dropshipStatus = dropshipStatus;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.callCnt = callCnt;
        this.lastUpdateDate = lastUpdateDate;
        this.remark = remark;
        this.stsCd = stsCd;
        this.shelfStock = shelfStock;
        this.preferDate = preferDate;
    }

    public storeDropshipItem() {
        super();
    }

    public Integer getDilId() {
        return dilId;
    }

    public void setDilId(Integer dilId) {
        this.dilId = dilId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getStrId() {
        return strId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public Integer getStoreRetention() {
        return storeRetention;
    }

    public void setStoreRetention(Integer storeRetention) {
        this.storeRetention = storeRetention;
    }

    public BigDecimal getDropshipPrice() {
        return dropshipPrice;
    }

    public void setDropshipPrice(BigDecimal dropshipPrice) {
        this.dropshipPrice = dropshipPrice;
    }

    public String getDropshipStatus() {
        return dropshipStatus;
    }

    public void setDropshipStatus(String dropshipStatus) {
        this.dropshipStatus = dropshipStatus == null ? null : dropshipStatus.trim();
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

    public Integer getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd == null ? null : stsCd.trim();
    }

    public Integer getShelfStock() {
        return shelfStock;
    }

    public void setShelfStock(Integer shelfStock) {
        this.shelfStock = shelfStock;
    }

    public Date getPreferDate() {
        return preferDate;
    }

    public void setPreferDate(Date preferDate) {
        this.preferDate = preferDate;
    }
}