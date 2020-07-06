package com.neusoft.bsp.business.po;

import com.neusoft.bsp.common.base.BaseEntity;

import java.sql.Date;
//品牌信息，一个公司（品牌商）可有多个品牌
public class Brand implements BaseEntity<Integer> {
    int brd_id;
    int man_id;
    String name_en;
    String name_cn;
    String created_by;
    Date creation_date;
    String last_updated_by;
    Date last_updated_date;
    String remark;
    String sts_cd;

    public Brand(String name_en,String remark) {
        this.name_en = name_en;
        this.remark = remark;
    }


    public Brand(int brd_id, int man_id, String name_en, String name_cn, String created_by, Date creation_date, String last_updated_by, Date last_updated_date, String remark, String sts_cd) {
        this.brd_id = brd_id;
        this.man_id = man_id;
        this.name_en = name_en;
        this.name_cn = name_cn;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_updated_by = last_updated_by;
        this.last_updated_date = last_updated_date;
        this.remark = remark;
        this.sts_cd = sts_cd;
    }

    public int getBrd_id() {
        return brd_id;
    }

    public void setBrd_id(int brd_id) {
        this.brd_id = brd_id;
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

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public Date getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(Date last_updated_date) {
        this.last_updated_date = last_updated_date;
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
}
