package com.pluralsight.product;

public abstract class Product {
    private String name;

    Product(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getCost();
}
