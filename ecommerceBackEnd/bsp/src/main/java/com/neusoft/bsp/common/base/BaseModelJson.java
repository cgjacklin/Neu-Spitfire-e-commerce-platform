package com.neusoft.bsp.common.base;

public class BaseModelJson<T> extends BaseModel {

    public T data;

    public void setData(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseModelJson{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
