package com.pluralsight.util;

import java.util.Scanner;

public final class InputValidation {
    public static int parseInt(String message, Scanner scanner){
        while(true){
            try{
                System.out.println(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Please enter a valid number");
            }
        }
    }
}
