package com.neusoft.bsp.admin.wallet.vo;

import com.neusoft.bsp.common.base.BaseEntity;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;

public class UseridAndAccount implements BaseEntity<Integer> {
    @NotNull(message = "The user_id shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class})
    int user_id;
    String account_name;
    String password;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
