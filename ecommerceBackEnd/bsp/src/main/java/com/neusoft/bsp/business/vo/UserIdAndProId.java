package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;

public class UserIdAndProId {
    @NotNull(message = "The user_id shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class})
    int user_id;
    int pro_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
}
