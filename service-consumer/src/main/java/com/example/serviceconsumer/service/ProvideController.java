package com.example.serviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProvideController {
    @Autowired
    ConsumerService consumerService;
    @GetMapping("/provide")
    public String getProvide(@RequestParam("name")String name){
        return consumerService.getProvide(name);
    }
}
