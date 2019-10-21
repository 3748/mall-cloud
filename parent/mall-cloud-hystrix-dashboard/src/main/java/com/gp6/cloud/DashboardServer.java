package com.gp6.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardServer {

    public static void main(String[] args) {
        SpringApplication.run(DashboardServer.class, args);
    }

}
