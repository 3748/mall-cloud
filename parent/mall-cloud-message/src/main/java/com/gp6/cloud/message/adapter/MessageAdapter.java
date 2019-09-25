package com.gp6.cloud.message.adapter;

/**
 * 统一发送消息接口(适配器)
 *
 * @author gp6
 * @date 2019/09/25
 */
public interface MessageAdapter {

    /**
     * 发送消息
     *
     * @param msg 消息内容
     */
    void sendMsg(String msg);
}
