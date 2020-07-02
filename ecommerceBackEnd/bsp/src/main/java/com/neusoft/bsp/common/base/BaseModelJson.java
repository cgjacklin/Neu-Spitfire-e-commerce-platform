package com.neusoft.bsp.common.base;

public class BaseModelJson<T> extends BaseModel {

    public T data;

    @Override
    public String toString() {
        return "BaseModelJson{" +
                "data=" + data +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
