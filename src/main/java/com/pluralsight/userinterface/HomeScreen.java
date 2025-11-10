package com.pluralsight.userinterface;

import com.pluralsight.data.Cart;
import com.pluralsight.data.ReceiptManager;
import com.pluralsight.product.Chips;
import com.pluralsight.product.Drink;
import com.pluralsight.product.Product;
import com.pluralsight.product.Sandwich;

import java.util.Scanner;

public class HomeScreen {
    private Cart myCart;

    public HomeScreen(){
        myCart = new Cart();
    }

    public void showHomeScreen(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Welcome to the sandwich shop!!!\n1) New Order\n0) Exit");
                int choice = scanner.nextInt();
                if (choice == 1)
                    showOrderMenu(scanner);
                else {
                    System.out.println("Have a good day!");
                    scanner.close();
                    return;
                }
            } catch (Exception e) {
                System.err.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }

    public void showOrderMenu(Scanner scanner){
        boolean didExit = false;
        while(!didExit){
            try{
                System.out.println("THE MENU");
                System.out.println("=========================================");
                System.out.println("""
                        1 - Sandwiches
                        2 - Chips
                        3 - Drinks
                        4 - Checkout
                        5 - Current shopping cart
                        0 - Cancel Order""");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice) {
                    case 1 -> addSandwich(scanner);
                    case 2 -> addChips(scanner);
                    case 3 -> addDrink(scanner);
                    case 4 -> {
                        checkout(scanner);
                        didExit = true;
                    }
                    case 5 -> showCart();
                    case 0 -> {
                        myCart.emptyShoppingCart();
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.err.println("Please enter a valid number!");
                scanner.nextLine();
            }
        }
    }

    public void showCart(){
        System.out.println("YOUR CURRENT CART");
        System.out.println("=====================================");
        myCart.getShoppingCart().stream()
                .map(Product::toString)
                .forEach(System.out::println);
    }

    public void addSandwich(Scanner scanner){
        String breadType;
        try{
            System.out.println("Please choose the type of bread you want.\n 1 - white, 2 - wheat, 3 - rye, 4 - wrap\nAny other option to return to menu.");
            int breadChoice = scanner.nextInt();
            scanner.nextLine();
            switch(breadChoice){
                case 1 -> breadType = "White";
                case 2 -> breadType = "Wheat";
                case 3 -> breadType = "Rye";
                case 4 -> breadType = "Wrap";
                default -> {
                    System.out.println("Returning to menu");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Returning to menu.");
            scanner.nextLine();
            return;
        }

        int breadSize;
        while(true){
            System.out.println("What size do you want your sandwich to be?\n4 - small, 8 - medium, 12 - large\n99 - back to menu");
            breadSize = scanner.nextInt();
            scanner.nextLine();
            if(breadSize == 99)
                return;
            if(breadSize == 4 || breadSize == 8 || breadSize == 12)
                break;
            System.err.println("You have selected an invalid size, please type again.");
        }

        System.out.println("Do you want it to be toasted?\nType yes if so.");
        String toastedInput = scanner.nextLine();
        boolean wantToasted = toastedInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich("Sandwich", breadType, breadSize, wantToasted);

        System.out.println("Please add a topping.");
        sandwich.addTopping(scanner);
        myCart.addProduct(sandwich);
        System.out.println("Sandwich added successfully");
    }

    public void addChips(Scanner scanner){
        while(true) {
            try {
                System.out.println("What chips do you want? 1 - BBQ, 2 - Sour Cream and Onion, 3 - Nacho Doritos\nType 99 to go back to menu");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> {
                        myCart.addProduct(new Chips("BBQ"));
                        return;
                    }
                    case 2 -> {
                        myCart.addProduct(new Chips("Sour Cream and Onion"));
                        return;
                    }
                    case 3 -> {
                        myCart.addProduct(new Chips("Nachos Doritos"));
                        return;
                    }
                    case 99 -> {
                        System.out.println("Going back to menu.");
                        return;
                    }
                    default -> System.err.println("Please enter a number 1-3!");
                }

            } catch (Exception e) {
                System.err.println("You have entered an invalid number");
                scanner.nextLine();
            }
        }
    }

    public void addDrink(Scanner scanner){
        //Asks the user what size of drink they want.
        int drinkSize = 0;
        boolean didExit = false;
        while(!didExit){
            try{
                System.out.println("What size do you want your drink?\n 1 - small($2), 2 - medium($2.50), 3 - large($3)");
                System.out.println("Type 99 tp exit");
                drinkSize = scanner.nextInt();
                scanner.nextLine();
                if(drinkSize == 99)
                    return;
                if(drinkSize < 1 || drinkSize > 3) {
                    System.out.println("Please enter a number from 1-3");
                    break;
                }
                didExit = true;
            } catch (Exception e) {
                System.err.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
        //Asks the user what drink type they want.
        while(true){
            try{
                System.out.println("What type of drink do you want?\n1 - Coke, 2 - Fanta, 3 - Sprite\nType 99 to return to menu.");
                int drinkChoice = scanner.nextInt();
                scanner.nextLine();
                if(drinkChoice == 99)
                    return;
                switch(drinkChoice){
                    case 1 -> myCart.addProduct(new Drink("Coke", drinkSize));
                    case 2 -> myCart.addProduct(new Drink("Fanta", drinkSize));
                    case 3 -> myCart.addProduct(new Drink("Sprite", drinkSize));
                    default -> {
                        System.err.println("Please enter a number from 1 - 3");
                        continue;
                    }
                }
                return;
            } catch (Exception e) {
                System.err.println("Please enter a valid number");
                scanner.nextLine();
            }
        }
    }

    public void checkout(Scanner scanner){
        //Will check if there is a sandwich. if there's not, then return and make the user order chips or a drink
        if(myCart.getShoppingCart().isEmpty()){
            System.out.println("You have to either order a sandwich, or have a drink/chips in order to check out.");
            return;
        }
        myCart.getShoppingCart().stream()
                .map(Product::toString)
                .forEach(System.out::println);
        System.out.println("Total cost will be: $" + String.format("%.2f", myCart.getTotalCost()));
        System.out.println("Type confirm to confirm your order, type cancel to cancel your order\nAny other input will return you back to the menu.");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("confirm")){
            ReceiptManager rf = new ReceiptManager();
            rf.saveReceipt(myCart);
            System.out.println("Enjoy!!");
        }
        else if(input.equalsIgnoreCase("cancel")){
            myCart.emptyShoppingCart();
        }
    }
}
