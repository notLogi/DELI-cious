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

    Scanner scanner = new Scanner(System.in);

    public HomeScreen(){
        myCart = new Cart();
    }

    public void showHomeScreen(){
        while(true) {
            System.out.println("Welcome to the sandwich shop!!!\n1) New Order\n0) Exit.");
            int choice = scanner.nextInt();
            if (choice == 1)
                showOrderMenu();
            else{
                System.out.println("Have a good day!");
                return;
            }

        }

    }

    public void showOrderMenu(){
        while(true){
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
            switch(choice){
                case 1 -> addSandwich();
                case 2 -> addChips();
                case 3 -> addDrink();
                case 4 -> {
                    checkout();
                    return;
                }
                case 5 -> showCart();
                case 0 -> {
                    myCart.emptyShoppingCart();
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    public void showCart(){
        myCart.getShoppingCart().stream()
                .map(Product::toString)
                .forEach(System.out::println);
    }

    public void addSandwich(){
        System.out.println("Please choose the type of bread you want.\n 1 - white, 2 - wheat, 3 - rye, 4 - wrap\nAny other option to return to menu.");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        String breadType;
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

        int breadSize;
        while(true){
            System.out.println("What size do you want your sandwich to be?\n4 - small, 8 - medium, 12 - large");
            breadSize = scanner.nextInt();
            scanner.nextLine();
            if(breadSize == 4 || breadSize == 8 || breadSize == 12)
                break;
            System.out.println("You have selected an invalid size, please type again.");
        }

        System.out.println("Do you want it to be toasted?\nType yes if so.");
        String toastedInput = scanner.nextLine();
        boolean wantToasted = toastedInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich("Sandwich", breadType, breadSize, wantToasted);

        System.out.println("Please add a topping.");
        sandwich.addTopping(scanner);
        while(true){
            System.out.println("Do you want to add more toppings?\n Type yes if so, any other response will default to no.");
            String extraToppingWanted = scanner.nextLine();
            if(extraToppingWanted.equalsIgnoreCase("yes")){
                sandwich.addTopping(scanner);
            }
            else
                break;
        }
        myCart.addProduct(sandwich);
        System.out.println("Sandwich added successfully");
    }

    public void addChips(){
        System.out.println("Confirm 1 if you want to add chips, else return.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice == 1) {
            System.out.println("Chips added successfully!");
            myCart.addProduct(new Chips("Chips"));
        }
    }

    public void addDrink(){
        System.out.println("What size do you want your drink?\n 1 - small($2), 2 - medium($2.50), 3 - large($3)");
        System.out.println("Any option will return you to the last screen.");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice > 3 || choice < 1){
            System.out.println("Returning to menu");
        }
        myCart.addProduct(new Drink("Drink", choice));
        System.out.println("Drink added successfully");
    }

    public void checkout(){
        //Will check if there is a sandwich. if there's not, then return and make the user order chips or a drink
        if(myCart.getShoppingCart().isEmpty()){
            System.out.println("You have to either order a sandwich, or have a drink/chips in order to check out.");
            return;
        }
        myCart.getShoppingCart().stream()
                .map(Product::toString)
                .forEach(System.out::println);
        System.out.println("Type confirm to confirm your order, type cancel to cancel your order");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("confirm")){
            ReceiptManager rf = new ReceiptManager();
            rf.saveReceipt(myCart);
        }
        else if(input.equalsIgnoreCase("cancel")){
            myCart.emptyShoppingCart();
        }
    }
}
