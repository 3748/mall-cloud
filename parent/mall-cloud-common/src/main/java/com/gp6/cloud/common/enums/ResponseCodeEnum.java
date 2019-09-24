package com.gp6.cloud.common.enums;

/**
 * 状态码与错误信息
 *
 * @author gp6
 * @date 2019-09-20
 */
public enum ResponseCodeEnum {


    REQUEST_PARAM_ERROR(10000, "参数错误!"),
    SYSTEM_ERROR(10001, "参数错误!"),



    ;


    /**
     * 返回状态码
     */
    private Integer status;

    /**
     * 返回错误信息
     */
    private String msg;

    ResponseCodeEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
