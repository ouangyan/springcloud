package com.example.serviceconsumer.controller;

import com.example.serviceconsumer.service.Product;
import com.example.serviceconsumer.service.ProductService2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProductController2实现容错保护
 */
@RequestMapping("/products")
@RestController
public class ProductController2 {
    @Autowired
    private ProductService2 productService2;

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
    public Product detail(@PathVariable String itemCode) {
        return this.productService2.loadByItemCode(itemCode);
    }
}
