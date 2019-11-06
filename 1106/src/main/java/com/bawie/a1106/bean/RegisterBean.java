package com.bawie.a1106.bean;

/**
 * author: 吕佳豪
 * data: 2019/11/6 08:8:44
 * function:
 */
public class RegisterBean {

    /**
     * message : 该手机号已注册，不能重复注册！
     * status : 1001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
