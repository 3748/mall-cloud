package com.gp6.cloud.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消息
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageServer {

    public static void main(String[] args) {
        SpringApplication.run(MessageServer.class, args);
    }

}
