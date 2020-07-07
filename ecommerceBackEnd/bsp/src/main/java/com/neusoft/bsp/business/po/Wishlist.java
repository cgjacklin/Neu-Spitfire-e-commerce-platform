package com.neusoft.bsp.business.po;

import java.sql.Date;

public class Wishlist {
    int wit_id;
    int dsr_id;
    int pro_id;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;

    public Wishlist(int wit_id, int dsr_id, int pro_id, String created_by, Date creation_date, String last_update_by, Date last_update_date, int call_cnt, String remark, String sts_cd) {
        this.wit_id = wit_id;
        this.dsr_id = dsr_id;
        this.pro_id = pro_id;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_update_by = last_update_by;
        this.last_update_date = last_update_date;
        this.call_cnt = call_cnt;
        this.remark = remark;
        this.sts_cd = sts_cd;
    }

    public int getWit_id() {
        return wit_id;
    }

    public void setWit_id(int wit_id) {
        this.wit_id = wit_id;
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
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