package com.example.serviceconsumer.controller;

import com.example.serviceconsumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/hi")
    public String hi(@RequestParam("name") String name){
        return productService.hi(name);
    }
}
