package com.neusoft.bsp.admin.dictionary.po;

import com.neusoft.bsp.common.base.BaseEntity;

import java.sql.Date;

public class Dictionary implements BaseEntity<Integer> {
    int cdm_id;
    String code_type;
    String description;
    String type_cd;
    String code_val;
    int seq_no;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;

    public Dictionary(){}
    public Dictionary(int cdm_id, String code_type, String description, String type_cd, String code_val, int seq_no, String created_by, Date creation_date, String last_update_by, Date last_update_date, int call_cnt, String remark, String sts_cd) {
        this.cdm_id = cdm_id;
        this.code_type = code_type;
        this.description = description;
        this.type_cd = type_cd;
        this.code_val = code_val;
        this.seq_no = seq_no;
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
        return "Dictionary{" +
                "cdm_id=" + cdm_id +
                ", code_type='" + code_type + '\'' +
                ", description='" + description + '\'' +
                ", type_cd='" + type_cd + '\'' +
                ", code_val='" + code_val + '\'' +
                ", seq_no=" + seq_no +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                '}';
    }


    public int getCdm_id() {
        return cdm_id;
    }

    public void setCdm_id(int cdm_id) {
        this.cdm_id = cdm_id;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_cd() {
        return type_cd;
    }

    public void setType_cd(String type_cd) {
        this.type_cd = type_cd;
    }

    public String getCode_val() {
        return code_val;
    }

    public void setCode_val(String code_val) {
        this.code_val = code_val;
    }

    public int getSeq_no() {
        return seq_no;
    }

    public void setSeq_no(int seq_no) {
        this.seq_no = seq_no;
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
