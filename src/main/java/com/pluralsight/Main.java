package com.pluralsight;

import com.pluralsight.product.Sandwich;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sandwich test = new Sandwich("Custom sandwich", "Rye", 4, true);
        test.addTopping(new Scanner(System.in));
        System.out.println("Total cost: " + test.getCost());
    }
}
