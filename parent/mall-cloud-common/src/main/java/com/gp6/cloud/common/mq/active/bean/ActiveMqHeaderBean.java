package com.gp6.cloud.common.mq.active.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ActiveMq消息头部
 *
 * @author gp6
 * @date 2019/09/25
 */
@Getter
@Setter
@ToString
public class ActiveMqHeaderBean implements Serializable {

    private static final long serialVersionUID = -2311156698005833344L;

    private String type;
}
