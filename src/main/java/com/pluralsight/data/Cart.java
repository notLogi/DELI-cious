package com.pluralsight.data;

import com.pluralsight.product.Product;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> shoppingCart;

    public Cart(){
        shoppingCart = new ArrayList<>();
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void addProduct(Product product){
        shoppingCart.add(product);
    }

    public void removeProduct(Product product){
        shoppingCart.remove(product);
    }

    public void emptyShoppingCart(){
        shoppingCart.clear();
    }

    public double getTotalCost(){
        return shoppingCart.stream()
                .map(Product::getCost)
                .reduce(0.0, Double::sum);
    }

}
