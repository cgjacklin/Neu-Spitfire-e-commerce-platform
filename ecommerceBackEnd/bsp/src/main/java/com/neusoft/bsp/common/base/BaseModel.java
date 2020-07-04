package com.neusoft.bsp.common.base;


public class BaseModel {

    public Integer code = 200;

    public String message;

    public void setSuccess(){
        this.message = "success";
        this.code = 200;
    }

    public void setFailure(){
        this.message = "failure";
        this.code = 500;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
