package com.example.serviceprovider2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试ribbon负载均衡使用
 */
@RestController
public class ProvideController {
    @RequestMapping("/provide")
    public String provide(@RequestParam("name")String name){
        return name+":你好呀这里是一个service-provider服务";
    }
}
