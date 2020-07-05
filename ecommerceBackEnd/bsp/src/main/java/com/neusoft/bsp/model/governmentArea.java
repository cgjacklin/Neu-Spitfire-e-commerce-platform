package com.neusoft.bsp.model;

import java.util.Date;

public class governmentArea {
    private Integer goaId;

    private String zipCode;

    private String state;

    private String stateShorthand;

    private String city;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Integer callCnt;

    private Date lastUpdateDate;

    private String remark;

    private String stsCd;

    public governmentArea(Integer goaId, String zipCode, String state, String stateShorthand, String city, String createdBy, Date creationDate, String lastUpdateBy, Integer callCnt, Date lastUpdateDate, String remark, String stsCd) {
        this.goaId = goaId;
        this.zipCode = zipCode;
        this.state = state;
        this.stateShorthand = stateShorthand;
        this.city = city;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.callCnt = callCnt;
        this.lastUpdateDate = lastUpdateDate;
        this.remark = remark;
        this.stsCd = stsCd;
    }

    public governmentArea() {
        super();
    }

    public Integer getGoaId() {
        return goaId;
    }

    public void setGoaId(Integer goaId) {
        this.goaId = goaId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getStateShorthand() {
        return stateShorthand;
    }

    public void setStateShorthand(String stateShorthand) {
        this.stateShorthand = stateShorthand == null ? null : stateShorthand.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
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
}