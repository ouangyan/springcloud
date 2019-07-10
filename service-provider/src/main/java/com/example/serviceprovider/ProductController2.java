package com.example.serviceprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试容错保护 hystrix
 */
@RestController
public class ProductController2 {
   @RequestMapping("/products")
    public Product detail(/*@PathVariable String itemCode*/@RequestParam(value = "itemCode", defaultValue = "xxx") String itemCode) {
       try {
           Thread.sleep(11000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       List<Product> products = this.buildProducts();
        for (Product product : products) {
            if (product.getItemCode().equalsIgnoreCase(itemCode))
                return product;
        }
        return null;
    }

    protected List<Product> buildProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("item-1", "测试商品-1", 100));
        products.add(new Product("item-2", "测试商品-2", 200));
        products.add(new Product("item-3", "测试商品-3", 300));
        return products;
    }
}
