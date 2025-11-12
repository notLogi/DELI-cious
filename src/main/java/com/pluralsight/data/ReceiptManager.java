package com.pluralsight.data;

import com.pluralsight.product.Product;

import java.time.LocalDateTime;
import java.io.*;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
    public void saveReceipt(Cart cart){
        LocalDateTime timeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = "receipts/" + timeNow.format(formatter) + ".txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("THANK YOU FOR SHOPPING AT DELI-BROS\n");
            writer.write("==================================================\n");
            writer.write("DELI-BROS\n");
            writer.write("==================================================\n");
            DateTimeFormatter receiptFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
            writer.write("Date: " + timeNow.format(receiptFormatter) + "\n");
            writer.write("--------------------------------------------------\n");
            for(Product product : cart.getShoppingCart()){
                writer.write(product.toString() + "\n");
            }
            writer.write("==================================================\n");
            writer.write("Total: $" + cart.getTotalCost()); 
        }
        catch(Exception ex){
            System.err.println("File not able to be saved.");
        }
    }
}
