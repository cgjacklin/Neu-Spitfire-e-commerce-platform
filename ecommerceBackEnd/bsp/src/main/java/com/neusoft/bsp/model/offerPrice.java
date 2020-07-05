package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class offerPrice {
    private Integer ofpId;

    private Integer manId;

    private Date effetiveStartDate;

    private Date effectiveEndDate;

    private Integer proId;

    private BigDecimal price;

    private String typeCd;

    private Integer dsrId;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private String period;

    public offerPrice(Integer ofpId, Integer manId, Date effetiveStartDate, Date effectiveEndDate, Integer proId, BigDecimal price, String typeCd, Integer dsrId, String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String remark, String stsCd, String period) {
        this.ofpId = ofpId;
        this.manId = manId;
        this.effetiveStartDate = effetiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
        this.proId = proId;
        this.price = price;
        this.typeCd = typeCd;
        this.dsrId = dsrId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.remark = remark;
        this.stsCd = stsCd;
        this.period = period;
    }

    public offerPrice() {
        super();
    }

    public Integer getOfpId() {
        return ofpId;
    }

    public void setOfpId(Integer ofpId) {
        this.ofpId = ofpId;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Date getEffetiveStartDate() {
        return effetiveStartDate;
    }

    public void setEffetiveStartDate(Date effetiveStartDate) {
        this.effetiveStartDate = effetiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTypeCd() {
        return typeCd;
    }

    public void setTypeCd(String typeCd) {
        this.typeCd = typeCd == null ? null : typeCd.trim();
    }

    public Integer getDsrId() {
        return dsrId;
    }

    public void setDsrId(Integer dsrId) {
        this.dsrId = dsrId;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }
}