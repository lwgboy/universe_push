package com.comsince.github.controller.im.model;

import com.comsince.github.common.ErrorCode;

public class RestResult {
    public enum  RestCode {
        SUCCESS(0, "success"),
        ERROR_INVALID_MOBILE(1, "无效的电话号码"),
        ERROR_SEND_SMS_OVER_FREQUENCY(3, "请求验证码太频繁"),
        ERROR_SERVER_ERROR(4, "服务器异常"),
        ERROR_CODE_EXPIRED(5, "验证码已过期"),
        ERROR_CODE_INCORRECT(6, "验证码错误"),
        ERROR_SERVER_CONFIG_ERROR(7, "服务器配置错误"),
        ERROR_SESSION_EXPIRED(8, "会话不存在或已过期"),
        ERROR_SESSION_NOT_VERIFIED(9, "会话没有验证"),
        ERROR_SESSION_NOT_SCANED(10, "会话没有被扫码");

        public int code;
        public String msg;

        RestCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

    }
    private int code;
    private String message;
    private Object result;

    public static RestResult ok(Object object) {
        return new RestResult(RestCode.SUCCESS, object);
    }

    public static RestResult error(RestCode code) {
        return new RestResult(code, null);
    }

    public static RestResult resultOf(ErrorCode errorCode) {
        return resultOf(errorCode, errorCode.msg, null);
    }

    public static RestResult resultOf(ErrorCode errorCode, String msg) {
        return resultOf(errorCode, msg, null);
    }

    public static RestResult resultOf(ErrorCode errorCode, String msg, Object object) {
        RestResult result = new RestResult();
        result.code = errorCode.code;
        result.message = msg;
        result.result = object;
        return result;
    }

    private RestResult(){

    }

    private RestResult(RestCode code, Object result) {
        this.code = code.code;
        this.message = code.msg;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
