package com.person.clinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者：进行测试并本地ribbon(负载均衡)调用服务
 */
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class ZKClient {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consume")
    public String consume(){
        String url = "http://zk-provider/provide";
        return restTemplate.getForObject(url,String.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ZKClient.class,args);
    }
    @Bean
    @LoadBalanced
    RestTemplate getInstance(){
        return  new RestTemplate();
    }
}
