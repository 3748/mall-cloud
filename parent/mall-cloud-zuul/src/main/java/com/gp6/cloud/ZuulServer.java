package com.gp6.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulServer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer.class, args);
    }

}
