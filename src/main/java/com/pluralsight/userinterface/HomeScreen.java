package com.pluralsight.userinterface;

import com.pluralsight.util.InputValidation;
import com.pluralsight.data.*;
import com.pluralsight.product.*;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreen {
    private Cart myCart;

    public HomeScreen(){
        myCart = new Cart();
    }

    public void showHomeScreen(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int choice = InputValidation.parseInt("WELCOME TO DELI BROS!!!\n1) New Order\n0) Exit", scanner);
            if (choice == 1)
                showOrderMenu(scanner);
            else if(choice == 0){
                System.out.println("Have a good day!");
                scanner.close();
                return;
            }
            else System.err.println("Please enter a valid option");
        }
    }

    public void showOrderMenu(Scanner scanner){
        boolean didExit = false;
        while(!didExit){
            int choice = InputValidation.parseInt("""
                THE MENU
                ==================================================
                
                1 - Sandwiches
                2 - Chips
                3 - Drinks
                4 - Checkout
                5 - Current Shopping Cart
                6 - Remove an Item
                0 - Cancel Order
                
                ==================================================
                """, scanner);

            switch(choice) {
                case 1 -> addSandwich(scanner);
                case 2 -> addChips(scanner);
                case 3 -> addDrink(scanner);
                case 4 -> didExit = checkout(scanner);
                case 5 -> showCart();
                case 6 -> myCart.removeProduct(scanner);
                case 0 -> {
                    myCart.emptyShoppingCart();
                    return;
                }
                default -> System.err.println("Please enter a valid option!");
            }
        }
    }
    //shows the current products the customer has
    public void showCart(){
        if(myCart.getShoppingCart().isEmpty()){
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("YOUR CURRENT CART");
        System.out.println("==================================================\n");
        myCart.getShoppingCart().stream()
                .map(Product::toString)
                .forEach(System.out::println);
        System.out.println("\n==================================================");
    }

    //add sandwich
    public void addSandwich(Scanner scanner){
        System.out.println("Make your own sandwich, or simply look at our signature sandwiches.\n" +
                "Type choose to look at our signatures. Any other option will default to create.");
        String optionCreateOwn = scanner.nextLine();
        int signatureChoice = 0;
        if(optionCreateOwn.equalsIgnoreCase("choose")){
            signatureChoice = chooseSandwich(scanner);
            if(signatureChoice == 0) return;
        }
        String breadType = chooseBreadType(scanner);
        if(breadType.isEmpty()) return;

        int breadSize = chooseBreadSize(scanner);
        if(breadSize == 0) return;

        System.out.println("Do you want it to be toasted?\nType yes if so.\nOther inputs will default to no.");
        String toastedInput = scanner.nextLine();
        boolean wantToasted = toastedInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich("Custom Sandwich", breadType, breadSize, wantToasted);

        if(optionCreateOwn.equalsIgnoreCase("choose")){
            sandwich.setListOfToppings(buildSignatureSandwich(signatureChoice, breadSize));
            System.out.println("Anymore toppings?");
        }
        else System.out.println("Please add a topping.");

        sandwich.addTopping(scanner);
        if(!sandwich.getListOfToppings().isEmpty()) {
            myCart.addProduct(sandwich);
            System.out.println("Sandwich added successfully");
            System.out.println("Do you want to remove any toppings?\nAny other option is no");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("yes")){
                System.out.println(sandwich);//toString is "redundant", can just print out sandwich details.
                sandwich.removeTopping(scanner);
            }
        }
        else System.out.println(":(");
    }

    //helper methods
    public String chooseBreadType(Scanner scanner){
        while(true) {
            int breadChoice = InputValidation.parseInt("Please choose the type of bread you want.\n 1 - white, 2 - wheat, 3 - rye, 4 - wrap", scanner);
            String breadType;
            switch (breadChoice) {
                case 1 -> breadType = "White";
                case 2 -> breadType = "Wheat";
                case 3 -> breadType = "Rye";
                case 4 -> breadType = "Wrap";
                default -> breadType = "";
            }
            if(breadType.isEmpty()){
                System.err.println("Please enter a valid choice.");
                continue;
            }
            return breadType;
        }
    }

    public int chooseBreadSize(Scanner scanner){
        while(true){
            int breadSize = InputValidation.parseInt("What size do you want your sandwich to be?\n4 - small, 8 - medium, 12 - large\n99 - back to menu", scanner);
            if (breadSize == 99) return 0;
            if (breadSize == 4 || breadSize == 8 || breadSize == 12)
                return breadSize;
            System.err.println("You have selected an invalid size, please type again.");
        }
    }

    public int chooseSandwich(Scanner scanner){
        while(true){
            int choice = InputValidation.parseInt("Here are sandwiches to choose from!\n1 - BLT, 2 - Chicken-Bacon Ranch\nType 99 to back", scanner);
            if(choice == 99) return 0;
            if(choice >= 1 && choice <= 2) return choice;
            System.out.println("Invalid choice, please enter a number 1-2");
        }
    }

    public ArrayList<Topping> buildSignatureSandwich(int choice, int size){
        ArrayList<Topping> toppings = new ArrayList<>();
        switch(choice){
            case 1:
                toppings.add(new Meat("Bacon", size, false));
                toppings.add(new Vegetable("Lettuce", false));
                toppings.add(new Vegetable("Tomato", false));
                break;
            case 2:
                toppings.add(new Meat("Chicken", size, false));
                toppings.add(new Meat("Bacon", size, false));
                toppings.add(new Sauce("Ranch", false));
        }
        return toppings;
    }

    //add drinks/chips
    public void addChips(Scanner scanner){
        while(true) {
            int choice = InputValidation.parseInt("What chips do you want? 1 - BBQ, 2 - Sour Cream and Onion, 3 - Nacho Doritos\nType 99 to go back to menu", scanner);
            if(choice >= 1 && choice <= 3){
                System.out.println("Chips successfully added");
            }
            switch (choice) {
                case 1 -> myCart.addProduct(new Chips("BBQ"));
                case 2 -> myCart.addProduct(new Chips("Sour Cream and Onion"));
                case 3 -> myCart.addProduct(new Chips("Nachos Doritos"));
                case 99 -> System.out.println("Going back to menu.");
                default -> {
                    System.err.println("Please enter a number 1-3!");
                    continue;
                }
            }
            return;
        }
    }

    public void addDrink(Scanner scanner){
        //Asks the user what size of drink they want.
        int drinkSize = 0;
        boolean didExit = false;
        while(!didExit){
            drinkSize = InputValidation.parseInt("What size do you want your drink?\n 1 - small($2), 2 - medium($2.50), 3 - large($3)\nType 99 tp exit", scanner);
            if(drinkSize == 99) return;
            if(drinkSize < 1 || drinkSize > 3) {
                System.err.println("Please enter a number from 1-3");
            }
            else{
                didExit = true;
            }
        }
        drinkChoice(scanner, drinkSize);
    }

    //helper method for drink to reduce the size of the addDrink method.
    public void drinkChoice(Scanner scanner, int drinkSize){
        //Asks the user what drink type they want.
        while(true){
            int drinkChoice = InputValidation.parseInt("What type of drink do you want?\n1 - Coke, 2 - Fanta, 3 - Sprite\nType 99 to return to menu.", scanner);
            if(drinkChoice == 99) return;
            if(drinkChoice >= 1 && drinkChoice <= 3){
                System.out.println("Drink successfully added");
            }
            switch(drinkChoice){
                case 1 -> {
                    myCart.addProduct(new Drink("Coke", drinkSize));
                    return;
                }
                case 2 -> {
                    myCart.addProduct(new Drink("Fanta", drinkSize));
                    return;
                }
                case 3 -> {
                    myCart.addProduct(new Drink("Sprite", drinkSize));
                    return;
                }
                default -> System.err.println("Please enter a number from 1 - 3");
            }
        }
    }

    //checkout
    public boolean checkout(Scanner scanner){
        //Will check if there is a sandwich. if there's not, then return and make the user order chips or a drink
        if(myCart.getShoppingCart().isEmpty()){
            System.out.println("You have to either order a sandwich, or have a drink/chips in order to check out.");
            return false;
        }
        showCart();
        System.out.println("Total cost will be: $" + String.format("%.2f", myCart.getTotalCost()));
        System.out.println("Type confirm to confirm your order, type cancel to cancel your order\nAny other input will return you back to the menu.");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("confirm")){
            ReceiptManager rf = new ReceiptManager();
            rf.saveReceipt(myCart);
            System.out.println("Enjoy!!");
            myCart.emptyShoppingCart();
            return true;
        }
        else if(input.equalsIgnoreCase("cancel")){
            myCart.emptyShoppingCart();
            return true;
        }
        return false;
    }

}
