package com.neusoft.bsp.business.po;

import com.neusoft.bsp.common.base.BaseEntity;

import java.sql.Date;

//公司、品牌商信息
public class Manufacturer implements BaseEntity<Integer> {
    int man_id;
    String name_en;
    String name_cn;
    String gmc_report_type;
    String gmc_report_url;
    String description;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    String sts_cd;

    public Manufacturer( String name_en,  String gmc_report_type, String gmc_report_url, String description) {
        this.name_en = name_en;
        this.gmc_report_type = gmc_report_type;
        this.gmc_report_url = gmc_report_url;
        this.description = description;
    }

    public Manufacturer(int man_id, String name_en, String name_cn, String gmc_report_type, String gmc_report_url, String description, String created_by, Date creation_date, String last_update_by, Date last_update_date, int call_cnt, String remark, String sts_cd) {
        this.man_id = man_id;
        this.name_en = name_en;
        this.name_cn = name_cn;
        this.gmc_report_type = gmc_report_type;
        this.gmc_report_url = gmc_report_url;
        this.description = description;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_update_by = last_update_by;
        this.last_update_date = last_update_date;
        this.call_cnt = call_cnt;
        this.remark = remark;
        this.sts_cd = sts_cd;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getGmc_report_type() {
        return gmc_report_type;
    }

    public void setGmc_report_type(String gmc_report_type) {
        this.gmc_report_type = gmc_report_type;
    }

    public String getGmc_report_url() {
        return gmc_report_url;
    }

    public void setGmc_report_url(String gmc_report_url) {
        this.gmc_report_url = gmc_report_url;
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

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
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

//    @Override
//    public Integer getId() {
//        return null;
//    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "man_id=" + man_id +
                ", name_en='" + name_en + '\'' +
                ", name_cn='" + name_cn + '\'' +
                ", gmc_report_type='" + gmc_report_type + '\'' +
                ", gmc_report_url='" + gmc_report_url + '\'' +
                ", description='" + description + '\'' +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_date=" + last_update_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                '}';
    }
}
