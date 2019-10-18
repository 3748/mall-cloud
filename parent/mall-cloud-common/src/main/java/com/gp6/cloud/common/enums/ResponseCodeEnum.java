package com.gp6.cloud.common.enums;

/**
 * 状态码与错误信息
 *
 * @author gp6
 * @date 2019-09-20
 */
public enum ResponseCodeEnum {

    SYSTEM_ERROR(10000, "系统错误!"),
    REQUEST_PARAM_ERROR(10001, "参数错误!"),
    CAST_ERROR(10002, "类型转换错误!"),


    MEMBER_REGISTER_SUCCESS(20000, "会员注册成功!"),
    MEMBER_REGISTER_FAIL(20001, "会员注册失败!"),
    MEMBER_HYSTRIX(20002, "会员查询--熔断!"),

    MQ_MESSAGE_TYPE_ERROR(30000, "MQ消息类型错误!"),
    MQ_MESSAGE_CONTENT_NOT_BLANK(30001, "MQ消息不能为空!"),
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
