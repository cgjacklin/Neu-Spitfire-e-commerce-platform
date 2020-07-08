package com.neusoft.bsp.common.exception;

/**
 * 业务错误，包含所有非系统错误
 */
public class BusinessException extends RuntimeException {
    public static final BusinessException USERNAME_NOT_EXISTS = new BusinessException(504, "User doesn't exist", new Object[0]);
    public static final BusinessException PASSWORD_WRONG = new BusinessException(504, "Password is wrong", new Object[0]);
    public static final BusinessException DUPLICATE_USERNAME = new BusinessException(504, "Duplicate User name", new Object[0]);
    public static final BusinessException NO_MAN_ID = new BusinessException(504, "User doesn't register manufacture");
    public static final BusinessException NO_PRODUCT = new BusinessException(504, "No product available");
    public static final BusinessException NO_BRAND = new BusinessException(504, "No brand available");

    public static final BusinessException INSERT_FAIL = new BusinessException(504, "Add operation failed", new Object[0]);
    public static final BusinessException DELETE_FAIL = new BusinessException(504, "Delete operation failed", new Object[0]);
    public static final BusinessException UPDATE_FAIL = new BusinessException(504, "Update operation failed", new Object[0]);
    public static final BusinessException USERID_NULL_ERROR = new BusinessException(504, "User null error", new Object[0]);

    public static final BusinessException NO_DSR_ID = new BusinessException(504, "Can't find corresponding dsr information", new Object[0]);
    public static final BusinessException NO_STORE_INFO = new BusinessException(504, "There's no store information", new Object[0]);
    public static final BusinessException NO_PERMISSION = new BusinessException(504, "This account don't have permission", new Object[0]);

    public static final BusinessException NO_PARAMETER = new BusinessException(504, "There is no parameter", new Object[0]);
    public static final BusinessException DUPLICATE_PARAM_CD = new BusinessException(504, "Duplicate primary key is set", new Object[0]);
    public static final BusinessException NO_DICTIONARY = new BusinessException(504, "There is no dictionary", new Object[0]);


    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
        this.msg = String.format(msg, args);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException newInstance(String msg, Object... args) {
        return new BusinessException(this.code, msg, args);
    }

}
