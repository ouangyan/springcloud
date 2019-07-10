package com.example.serviceprovider;

public class Product {
    private String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public Product(String itemCode,String name,int price){
        this.itemCode=itemCode;
        this.name=name;
        this.price=price;
    }
}
