package com.person.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient  //不是Eureke注册中心使用该注解
public class ZKServer {

    @Value("${server.port}")
    private String  port;

    @RequestMapping("/provide")
    public String provide(){
         return "服务提供者，请消费"+port;
    }
    public static void main(String[] args) {
        SpringApplication.run(ZKServer.class,args);
    }
}
