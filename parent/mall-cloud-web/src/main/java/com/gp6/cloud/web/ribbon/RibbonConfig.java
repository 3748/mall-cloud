package com.gp6.cloud.web.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon配置
 *
 * @author gp6
 * @date 2019/10/12
 */
@Configuration
public class RibbonConfig {

    /**
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        // 轮询
        // return new RoundRobinRule();
        // 随机
        // return new RandomRule();
        // 重试
        return new RetryRule();
    }
}

