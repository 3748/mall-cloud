package com.gp6.cloud.common.mq.active.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * ActiveMq消息
 *
 * @author gp6
 * @date 2019/09/25
 */
@Getter
@Setter
@ToString
public class ActiveMqBean implements Serializable {

    private static final long serialVersionUID = -3348270504376261587L;

    /**
     * MQ消息头部
     */
    private ActiveMqHeaderBean headerBean;

    /**
     * MQ消息内容
     */
    private Map<String, Object> content;
}
