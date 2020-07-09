package com.neusoft.bsp.admin.parameter.po;

import com.neusoft.bsp.business.vo.ParameterVO;
import com.neusoft.bsp.common.base.BaseEntity;

import java.sql.Date;

public class Parameter implements BaseEntity<Integer> {
    int par_id;
    String param_cd;
    String param_value;
    String description;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;

    public Parameter(){}

    public Parameter(ParameterVO parameterVO){
        this.par_id = parameterVO.getPar_id();
        this.param_cd = parameterVO.getParam_cd();
        this.param_value = parameterVO.getParam_value();
        this.description = parameterVO.getDescription();
        this.created_by = parameterVO.getCreated_by();
        this.creation_date = parameterVO.getCreation_date();
        this.last_update_by = parameterVO.getLast_update_by();
        this.last_update_date = parameterVO.getLast_update_date();
        this.call_cnt = parameterVO.getCall_cnt();
        this.remark = parameterVO.getRemark();
        this.sts_cd = parameterVO.getSts_cd();
    }

    public Parameter(int par_id, String param_cd, String param_value, String description, String created_by, Date creation_date, String last_update_by, Date last_update_date, int call_cnt, String remark, String sts_cd) {
        this.par_id = par_id;
        this.param_cd = param_cd;
        this.param_value = param_value;
        this.description = description;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_update_by = last_update_by;
        this.last_update_date = last_update_date;
        this.call_cnt = call_cnt;
        this.remark = remark;
        this.sts_cd = sts_cd;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "par_id=" + par_id +
                ", param_cd='" + param_cd + '\'' +
                ", param_value='" + param_value + '\'' +
                ", description='" + description + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                '}';
    }

    public int getPar_id() {
        return par_id;
    }

    public void setPar_id(int par_id) {
        this.par_id = par_id;
    }

    public String getParam_cd() {
        return param_cd;
    }

    public void setParam_cd(String param_cd) {
        this.param_cd = param_cd;
    }

    public String getParam_value() {
        return param_value;
    }

    public void setParam_value(String param_value) {
        this.param_value = param_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }
}
