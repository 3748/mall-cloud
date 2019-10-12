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
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端       负载均衡的工具。
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
        //return new RoundRobinRule();
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
        return new RetryRule();
    }
}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">