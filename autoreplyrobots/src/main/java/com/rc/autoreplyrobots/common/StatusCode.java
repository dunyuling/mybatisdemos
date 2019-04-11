package com.rc.autoreplyrobots.common;

/**
 * @ClassName StatusCode
 * @Description 状态码类
 * @Author liux
 * @Date 19-4-11 上午11:51
 * @Version 1.0
 */
public enum StatusCode {

    Success(0,"成功"), Failure(1,"失败");

    private Integer code;
    private String msg;

    StatusCode() {
    }

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}