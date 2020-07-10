package com.neusoft.bsp.admin.wallet.vo;

import com.neusoft.bsp.common.base.BaseEntity;

public class Audit implements BaseEntity<Integer> {
    int admin_id;
    int user_id;
    int transaction_audit_id;
    int status;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTransaction_audit_id() {
        return transaction_audit_id;
    }

    public void setTransaction_audit_id(int transaction_audit_id) {
        this.transaction_audit_id = transaction_audit_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
