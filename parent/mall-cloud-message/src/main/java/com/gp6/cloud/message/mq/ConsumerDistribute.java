package com.gp6.cloud.message.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.enums.TypeEnum;
import com.gp6.cloud.common.exceptions.MallException;
import com.gp6.cloud.common.mq.active.bean.ActiveMqBean;
import com.gp6.cloud.message.adapter.MessageAdapter;
import com.gp6.cloud.message.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消费者
 *
 * @author gp6
 * @date 2019/09/25
 */
@Component
@Slf4j
public class ConsumerDistribute {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 消息适配器
     */
    private MessageAdapter messageAdapter;

    @Autowired
    private EmailService emailService;

    /**
     * 监听消息
     *
     * @param msg 参数
     */
    @JmsListener(destination = "messages_queue")
    public void distribute(String msg) {
        try {
            log.info("---------消息服务平台接受消息内容:{}--------", msg);
            if (StringUtils.isBlank(msg)) {
                throw new MallException(ResponseCodeEnum.MQ_MESSAGE_CONTENT_NOT_BLANK);
            }
            // 获取消息内容
            ActiveMqBean activeMqBean = OBJECT_MAPPER.readValue(msg, ActiveMqBean.class);
            String type = activeMqBean.getHeaderBean().getType();
            String content = activeMqBean.getContent().get("content").toString();

            if (StringUtils.isEmpty(type)) {
                log.info("消息类型为空");
                return;

                // 判断接口类型是否为发邮件
            } else if (TypeEnum.MQ_MESSAGE_EMAIL.getType().equals(type)) {
                messageAdapter = emailService;
            } else {
                log.info("消息类型为未知类型,type:[{}]", type);
                return;
            }
            messageAdapter.sendMsg(content);
        } catch (IOException e) {
            log.error("类型转换异常,原因:[{}]:", e);
        }
    }

}
