package com.pluralsight;

import com.pluralsight.product.Product;
import com.pluralsight.product.Sandwich;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product test = new Sandwich("Custom sandwich", "Rye", 4, true);
        ((Sandwich) test).addTopping(new Scanner(System.in));
        System.out.println("Total cost: " + test.getCost());
    }
}
