package com.gp6.cloud.member.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gp6.cloud.api.member.MemberApi;
import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.enums.NumEnum;
import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.enums.TypeEnum;
import com.gp6.cloud.common.exceptions.MallException;
import com.gp6.cloud.common.mq.active.ActiveMqUtil;
import com.gp6.cloud.common.mq.active.bean.ActiveMqBean;
import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.common.utils.DateTimeUtil;
import com.gp6.cloud.common.utils.ValidateUtil;
import com.gp6.cloud.member.mapper.MemberMapper;
import com.gp6.cloud.member.mq.RegisterMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员实现类
 *
 * @author gp6
 * @date 2019/09/22
 */
@Slf4j
@RestController
public class MemberApiImpl implements MemberApi {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private RegisterMessageProducer registerMessageProducer;

    @Value("${messages.queue}")
    private String messageQueue;

    @Override
    public MallResponse selectList() {
        List<Member> memberList = memberMapper.selectAll();
        return MallResponse.ok(memberList);
    }

    //@Transactional(rollbackFor = Exception.class)
    @Override
    public MallResponse register(@RequestBody Member member) {
        throw new MallException(ResponseCodeEnum.REQUEST_PARAM_ERROR);
        // 参数校验
//        ValidateUtil.validate(member);
//        member.setCreateTime(DateTimeUtil.getCurrentTime());
//        if (memberMapper.insert(member) <= 0) {
//            return MallResponse.build(ResponseCodeEnum.MEMBER_REGISTER_FAIL);
//        }
//        // 采用异步方式发送邮件
//        sendMqMsg(member.getEmail());
//        return MallResponse.build(ResponseCodeEnum.MEMBER_REGISTER_SUCCESS);
    }

    /**
     * 发送消息到队列
     *
     * @param email 邮件地址
     */
    private void sendMqMsg(String email) {
        // 封装消息内容
        ActiveMqBean activeMqBean = new ActiveMqBean();
        // 消息头部
        activeMqBean.setHeaderBean(ActiveMqUtil.packHeader(TypeEnum.MQ_MESSAGE_SMS.getType()));
        // 消息内容
        Map<String, Object> map = new HashMap<>(NumEnum.TWO.getNum());
        ActiveMqUtil.packContent("content", email, map);
        activeMqBean.setContent(map);
        String msg;
        try {
            msg = OBJECT_MAPPER.writeValueAsString(activeMqBean);
        } catch (JsonProcessingException e) {
            log.error("类型转换异常,原因:[{}]", e);
            throw new MallException(ResponseCodeEnum.CAST_ERROR);
        }
        ActiveMQQueue activeMQQueue = new ActiveMQQueue(messageQueue);
        registerMessageProducer.sendMsg(activeMQQueue, msg);
    }
}
