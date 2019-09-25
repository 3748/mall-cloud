package com.gp6.cloud.common.mq.active;

import com.gp6.cloud.common.mq.active.bean.ActiveMqHeaderBean;

import java.util.Map;

/**
 * ActiveMq工具类
 *
 * @author gp6
 * @date 2019/09/25
 */
public class ActiveMqUtil {

    /**
     * 封装消息头部
     *
     * @param type 消息类型
     * @return 消息头部
     */
    public static ActiveMqHeaderBean packHeader(String type) {
        ActiveMqHeaderBean activeMqHeaderBean = new ActiveMqHeaderBean();
        activeMqHeaderBean.setType(type);
        return activeMqHeaderBean;
    }

    /**
     * 封装消息内容
     *
     * @param key   键
     * @param value 值
     * @param map   消息内容
     */
    public static void packContent(String key, Object value, Map<String, Object> map) {
        map.put(key, value);
    }
}
