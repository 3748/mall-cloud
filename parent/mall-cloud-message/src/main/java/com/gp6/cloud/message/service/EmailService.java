package com.gp6.cloud.message.service;

import com.gp6.cloud.message.adapter.MessageAdapter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 邮件发送
 *
 * @author gp6
 * @date 2019/09/25
 */
@Slf4j
@Service
public class EmailService implements MessageAdapter {

    @Override
    public void sendMsg(String email) {
        // 处理发送邮件
        if (StringUtils.isEmpty(email)) {
            return;
        }
        log.info("消息服务平台发送邮件:{}", email);
    }
}
