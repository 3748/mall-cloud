package com.gp6.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费者
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberServer {

    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class, args);
    }

}
