package com.gp6.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 消费者
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.gp6.cloud.mapper")
public class MemberServer {

    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class, args);
    }

}
