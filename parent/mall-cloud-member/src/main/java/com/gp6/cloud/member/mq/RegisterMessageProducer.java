package com.gp6.cloud.member.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 注册消息生产者
 *
 * @author gp6
 * @date 2019/09/25
 */
@Service
public class RegisterMessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息到队列中
     *
     * @param destination 队列
     * @param msg         邮箱/手机号信信息
     */
    public void sendMsg(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }
}
