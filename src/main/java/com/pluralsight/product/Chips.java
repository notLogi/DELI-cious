package com.pluralsight.product;

public class Chips extends Product{


    public Chips(String name){
        super(name);
    }

    @Override
    public double getCost(){
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips: " + getCost() + "\n";
    }
}
