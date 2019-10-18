package com.gp6.cloud.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 会员
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.gp6.cloud.member.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MemberServer {

    public static void main(String[] args) {
        SpringApplication.run(MemberServer.class, args);
    }

}
