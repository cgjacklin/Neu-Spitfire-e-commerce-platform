package com.neusoft.bsp.model;

import java.util.Date;

public class storeOrder {
    private Integer stoId;

    private Integer strId;

    private String orderId;

    private String orderCreatedTime;

    private String paidTime;

    private String lastModifiedTime;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private String plateformType;

    private String cancelCompleteDate;

    public storeOrder(Integer stoId, Integer strId, String orderId, String orderCreatedTime, String paidTime, String lastModifiedTime, String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String remark, String stsCd, String plateformType, String cancelCompleteDate) {
        this.stoId = stoId;
        this.strId = strId;
        this.orderId = orderId;
        this.orderCreatedTime = orderCreatedTime;
        this.paidTime = paidTime;
        this.lastModifiedTime = lastModifiedTime;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.remark = remark;
        this.stsCd = stsCd;
        this.plateformType = plateformType;
        this.cancelCompleteDate = cancelCompleteDate;
    }

    public storeOrder() {
        super();
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public Integer getStrId() {
        return strId;
    }

    public void setStrId(Integer strId) {
        this.strId = strId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderCreatedTime() {
        return orderCreatedTime;
    }

    public void setOrderCreatedTime(String orderCreatedTime) {
        this.orderCreatedTime = orderCreatedTime == null ? null : orderCreatedTime.trim();
    }

    public String getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime == null ? null : paidTime.trim();
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime == null ? null : lastModifiedTime.trim();
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

    public String getPlateformType() {
        return plateformType;
    }

    public void setPlateformType(String plateformType) {
        this.plateformType = plateformType == null ? null : plateformType.trim();
    }

    public String getCancelCompleteDate() {
        return cancelCompleteDate;
    }

    public void setCancelCompleteDate(String cancelCompleteDate) {
        this.cancelCompleteDate = cancelCompleteDate == null ? null : cancelCompleteDate.trim();
    }
}