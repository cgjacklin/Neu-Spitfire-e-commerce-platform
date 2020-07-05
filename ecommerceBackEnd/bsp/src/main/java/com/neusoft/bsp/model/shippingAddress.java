package com.neusoft.bsp.model;

import java.util.Date;

public class shippingAddress {
    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private String familyName;

    private String givenName;

    private String countryName;

    private String countryIsoCd;

    private String stateOrProvinceName;

    private String stateOrProvinceCd;

    private String cityName;

    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String postalCd;

    private String contactPhoneNo;

    private String email;

    private Integer stoId;

    private String carrierName;

    public shippingAddress(String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String remark, String stsCd, String familyName, String givenName, String countryName, String countryIsoCd, String stateOrProvinceName, String stateOrProvinceCd, String cityName, String addressLine1, String addressLine2, String addressLine3, String postalCd, String contactPhoneNo, String email, Integer stoId, String carrierName) {
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.remark = remark;
        this.stsCd = stsCd;
        this.familyName = familyName;
        this.givenName = givenName;
        this.countryName = countryName;
        this.countryIsoCd = countryIsoCd;
        this.stateOrProvinceName = stateOrProvinceName;
        this.stateOrProvinceCd = stateOrProvinceCd;
        this.cityName = cityName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.postalCd = postalCd;
        this.contactPhoneNo = contactPhoneNo;
        this.email = email;
        this.stoId = stoId;
        this.carrierName = carrierName;
    }

    public shippingAddress() {
        super();
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

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName == null ? null : givenName.trim();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    public String getCountryIsoCd() {
        return countryIsoCd;
    }

    public void setCountryIsoCd(String countryIsoCd) {
        this.countryIsoCd = countryIsoCd == null ? null : countryIsoCd.trim();
    }

    public String getStateOrProvinceName() {
        return stateOrProvinceName;
    }

    public void setStateOrProvinceName(String stateOrProvinceName) {
        this.stateOrProvinceName = stateOrProvinceName == null ? null : stateOrProvinceName.trim();
    }

    public String getStateOrProvinceCd() {
        return stateOrProvinceCd;
    }

    public void setStateOrProvinceCd(String stateOrProvinceCd) {
        this.stateOrProvinceCd = stateOrProvinceCd == null ? null : stateOrProvinceCd.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1 == null ? null : addressLine1.trim();
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2 == null ? null : addressLine2.trim();
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3 == null ? null : addressLine3.trim();
    }

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd == null ? null : postalCd.trim();
    }

    public String getContactPhoneNo() {
        return contactPhoneNo;
    }

    public void setContactPhoneNo(String contactPhoneNo) {
        this.contactPhoneNo = contactPhoneNo == null ? null : contactPhoneNo.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName == null ? null : carrierName.trim();
    }
}