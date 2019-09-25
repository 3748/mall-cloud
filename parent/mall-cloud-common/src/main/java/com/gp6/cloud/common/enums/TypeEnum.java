package com.gp6.cloud.common.enums;

/**
 * 所用数字
 *
 * @author gp6
 * @date 2019-01-03
 */
public enum TypeEnum {

    MQ_MESSAGE_EMAIL("1", "邮箱"),
    MQ_MESSAGE_SMS("2", "短信"),


    ;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String desc;

    TypeEnum(String key, String desc) {
        this.type = key;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
