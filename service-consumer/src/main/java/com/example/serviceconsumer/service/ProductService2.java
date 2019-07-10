package com.example.serviceconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
* 让ProductService2具有容错能力
* */
@FeignClient(value = "service-provider", fallback = ProductServiceFallback.class)
public interface ProductService2 {
    @GetMapping("/products")
    Product loadByItemCode(@RequestParam("itemCode")String itemCode);
}
