package com.person.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * 使用consul作为注册中心
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsulServer {

    //可以获取指定服务别名的注册中心的信息
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("info")
    public String getServiceInfo(){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-server");
        for(ServiceInstance instance: instances){
            URI uri = instance.getUri();
            String result = uri.toString();
           return  result;
        }
        return  null;
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsulServer.class,args);
    }
}
