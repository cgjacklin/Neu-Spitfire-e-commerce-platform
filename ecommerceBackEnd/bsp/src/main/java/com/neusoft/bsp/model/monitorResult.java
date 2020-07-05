package com.neusoft.bsp.model;

import java.util.Date;

public class monitorResult {
    private Integer morId;

    private String className;

    private String jsonString;

    private Date createDate;

    private String createBy;

    private Date updateDate;

    private String updateBy;

    private String remark;

    private String stsCd;

    public monitorResult(Integer morId, String className, String jsonString, Date createDate, String createBy, Date updateDate, String updateBy, String remark, String stsCd) {
        this.morId = morId;
        this.className = className;
        this.jsonString = jsonString;
        this.createDate = createDate;
        this.createBy = createBy;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.remark = remark;
        this.stsCd = stsCd;
    }

    public monitorResult() {
        super();
    }

    public Integer getMorId() {
        return morId;
    }

    public void setMorId(Integer morId) {
        this.morId = morId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString == null ? null : jsonString.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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