package com.example.serviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试ribbon负载均衡用
 */
@Service
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    public String getProvide(String name){
        // 使用Application.name来访问服务提供者  (此处的Application.name一定要大写)
        return restTemplate.getForObject("http://SERVICE-PROVIDER/provide?name="+name,String.class);
    }
}
