package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.common.base.BaseEntity;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;

public class ManufacturerWithUserId implements BaseEntity<Integer> {

    @NotNull(message = "The user_id shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class})
    int user_id;
    String name_en;
    String gmc_report_type;
    String gmc_report_url;
    String description;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
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
}
