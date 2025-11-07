package com.pluralsight.product;

public class Chips extends Product{

    Chips(String name){
        super(name);
    }

    @Override
    public double getCost(){
        return 1.50;
    }
}
