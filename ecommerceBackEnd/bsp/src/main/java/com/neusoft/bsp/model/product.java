package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class product {
    private Integer proId;

    private String skuCd;

    private Integer brdId;

    private Integer manId;

    private String title;

    private String upc;

    private String ean;

    private String model;

    private String warrantyDay;

    private BigDecimal retailPrice;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private BigDecimal mininumRetailPrice;

    private Integer replenishmentPeriod;

    private String keyWords;

    private String timeUnit;

    private Integer stockseting;

    private String warranty;

    public product(Integer proId, String skuCd, Integer brdId, Integer manId, String title, String upc, String ean, String model, String warrantyDay, BigDecimal retailPrice, String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String remark, String stsCd, BigDecimal mininumRetailPrice, Integer replenishmentPeriod, String keyWords, String timeUnit, Integer stockseting, String warranty) {
        this.proId = proId;
        this.skuCd = skuCd;
        this.brdId = brdId;
        this.manId = manId;
        this.title = title;
        this.upc = upc;
        this.ean = ean;
        this.model = model;
        this.warrantyDay = warrantyDay;
        this.retailPrice = retailPrice;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.remark = remark;
        this.stsCd = stsCd;
        this.mininumRetailPrice = mininumRetailPrice;
        this.replenishmentPeriod = replenishmentPeriod;
        this.keyWords = keyWords;
        this.timeUnit = timeUnit;
        this.stockseting = stockseting;
        this.warranty = warranty;
    }

    public product() {
        super();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getSkuCd() {
        return skuCd;
    }

    public void setSkuCd(String skuCd) {
        this.skuCd = skuCd == null ? null : skuCd.trim();
    }

    public Integer getBrdId() {
        return brdId;
    }

    public void setBrdId(Integer brdId) {
        this.brdId = brdId;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc == null ? null : upc.trim();
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean == null ? null : ean.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getWarrantyDay() {
        return warrantyDay;
    }

    public void setWarrantyDay(String warrantyDay) {
        this.warrantyDay = warrantyDay == null ? null : warrantyDay.trim();
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
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

    public BigDecimal getMininumRetailPrice() {
        return mininumRetailPrice;
    }

    public void setMininumRetailPrice(BigDecimal mininumRetailPrice) {
        this.mininumRetailPrice = mininumRetailPrice;
    }

    public Integer getReplenishmentPeriod() {
        return replenishmentPeriod;
    }

    public void setReplenishmentPeriod(Integer replenishmentPeriod) {
        this.replenishmentPeriod = replenishmentPeriod;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords == null ? null : keyWords.trim();
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit == null ? null : timeUnit.trim();
    }

    public Integer getStockseting() {
        return stockseting;
    }

    public void setStockseting(Integer stockseting) {
        this.stockseting = stockseting;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty == null ? null : warranty.trim();
    }
}