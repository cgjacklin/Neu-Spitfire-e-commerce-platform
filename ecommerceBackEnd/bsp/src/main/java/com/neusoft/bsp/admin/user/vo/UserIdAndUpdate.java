package com.neusoft.bsp.admin.user.vo;

import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;

public class UserIdAndUpdate {
    @NotNull(message = "The admin_id shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class})
    int admin_id;
    @NotNull(message = "The user_id shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class, DeleteGroup.class})
    int user_id;
    String username;
    String password;
    String name;
//    String ip;
//    String status;
//    String bz;
//    String skin;
    String email;
//    String number;
    String phone;
//    int man_buyer_id;
    String role_id;

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getBz() {
//        return bz;
//    }
//
//    public void setBz(String bz) {
//        this.bz = bz;
//    }
//
//    public String getSkin() {
//        return skin;
//    }
//
//    public void setSkin(String skin) {
//        this.skin = skin;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public int getMan_buyer_id() {
//        return man_buyer_id;
//    }
//
//    public void setMan_buyer_id(int man_buyer_id) {
//        this.man_buyer_id = man_buyer_id;
//    }
//

}
