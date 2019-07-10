package com.example.serviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @FeignClient注解的作用目标在接口上
 */
@FeignClient(value="service-provider")
public interface ProductService {
    @GetMapping("/hi")
    String hi(@RequestParam("name") String name);
}
