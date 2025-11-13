package com.pluralsight.product;

import com.pluralsight.checkers.InputValidation;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich extends Product{
    private String breadType;
    private int size;
    private ArrayList<Topping> listOfToppings;
    private boolean isToasted;

    public Sandwich(String name, String breadType, int size, boolean isToasted){
        super(name);
        listOfToppings = new ArrayList<>();
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public ArrayList<Topping> getListOfToppings(){
        return listOfToppings;
    }

    public void setListOfToppings(ArrayList<Topping> listOfToppings) {
        this.listOfToppings = listOfToppings;
    }

    public void removeTopping(Scanner scanner){
        while(true){
            System.out.println("What toppings do you want to remove? Type 99 to return.");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("99")) return;
            boolean removed = listOfToppings.removeIf(topping -> choice.equalsIgnoreCase(topping.getName()));
            if(!removed) System.out.println("The topping you inputted in is not included in the sandwich");
            else System.out.println("Removed successfully");
            System.out.println("Anymore toppings to remove?\nAny other option is no.");
            String again = scanner.nextLine();
            if(!again.equalsIgnoreCase("yes")){
                break;
            }

        }
    }

    public void addTopping(Scanner scanner){
        while(true) {
            int choice = InputValidation.parseInt("What toppings do you want? Type 1-5, meat, cheese, vegetables, sauces, and sides, respectively.\nType 99 to back.", scanner);
            if (choice == 99) {
                return;
            }
            switch (choice) {
                case 1 -> processMeatChoice(scanner);
                case 2 -> processCheeseChoice(scanner);
                case 3 -> processVegetableChoice(scanner);
                case 4 -> processSauceChoice(scanner);
                case 5 -> processSideChoice(scanner);
                default -> System.err.println("Please choose a valid option!");
            }
        }
    }

    public void processMeatChoice(Scanner scanner) {
        while(true) {
            int meatChoice = InputValidation.parseInt("""
                    Meats
                    1 - steak
                    2 - ham
                    3 - salami
                    4 - roast beef
                    5 - chicken
                    6 - bacon
                    99 - back""", scanner);
            if (meatChoice == 99) return;

            String name;
            switch (meatChoice) {
                case 1 -> name = "steak";
                case 2 -> name = "ham";
                case 3 -> name = "salami";
                case 4 -> name = "roast beef";
                case 5 -> name = "chicken";
                case 6 -> name = "bacon";
                default -> name = "";
            }
            if (!name.isEmpty()) {
                System.out.println("Do you want extra meat?\nType yes if you do, leave blank if you don't");
                String choiceExtra = scanner.nextLine();
                boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
                listOfToppings.add(new Meat(name, size, wantsExtra));
                System.out.println("Meat topping added successfully");
                return;
            }
            System.err.println("Invalid choice for meat");
        }
    }
    public void processCheeseChoice(Scanner scanner) {
        while (true) {
            int cheeseChoice = InputValidation.parseInt("""
                    Cheeses
                    1 - american
                    2 - provolone
                    3 - cheddar
                    4 - swiss
                    99 - back
                    """, scanner);//readInteger, make a helper method that helps parse an integer, take in a string as an argument
            if (cheeseChoice == 99) return;

            String name;
            switch (cheeseChoice) {
                case 1 -> name = "american";
                case 2 -> name = "provolone";
                case 3 -> name = "cheddar";
                case 4 -> name = "swiss";
                default -> name = "";
            }

            if (!name.isEmpty()) {
                System.out.println("Do you want extra cheese?\nType yes if you do, leave blank if you don't");
                String choiceExtra = scanner.nextLine();
                boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
                listOfToppings.add(new Cheese(name, size, wantsExtra));
                System.out.println("Cheese topping added successfully");
                return;
            }
            System.err.println("Invalid choice for cheese");
        }
    }

    public void processVegetableChoice(Scanner scanner){
        while(true) {
            int vegetableChoice = InputValidation.parseInt("""
                    Vegetables
                    1 - lettuce
                    2 - peppers
                    3 - onions
                    4 - tomatoes
                    5 - jalapenos
                    6 - cucumbers
                    7 - pickles
                    8 - guacamole
                    9 - mushrooms
                    99 - back""", scanner);
            if (vegetableChoice == 99) return;

            String name;
            switch (vegetableChoice) {
                case 1 -> name = "lettuce";
                case 2 -> name = "peppers";
                case 3 -> name = "onions";
                case 4 -> name = "tomatoes";
                case 5 -> name = "jalapenos";
                case 6 -> name = "cucumbers";
                case 7 -> name = "pickles";
                case 8 -> name = "guacamole";
                case 9 -> name = "mushrooms";
                default -> name = "";
            }

            if (!name.isEmpty()) {
                System.out.println("Do you want extra veggies?\nType yes if you do, leave blank if you don't");
                String choiceExtra = scanner.nextLine();
                boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
                listOfToppings.add(new Vegetable(name, wantsExtra));
                System.out.println("Veggie topping added successfully");
                return;
            }
            System.err.println("Invalid choice for veggies");
        }

    }

    public void processSauceChoice(Scanner scanner) {
        while (true) {
            int sauceChoice = InputValidation.parseInt("""
                    Sauces
                    1 - mayo
                    2 - ketchup
                    3 - ranch
                    4 - thousand islands
                    5 - vinaigrette
                    99 - back""", scanner);
            if (sauceChoice == 99) return;

            String name;
            switch (sauceChoice) {
                case 1 -> name = "mayo";
                case 2 -> name = "ketchup";
                case 3 -> name = "ranch";
                case 4 -> name = "thousand islands";
                case 5 -> name = "vinaigrette";
                default -> name = "";
            }
            if (!name.isEmpty()) {
                System.out.println("Do you want extra sauce?\nType yes if you do, any other input defaults to no.");
                String choiceExtra = scanner.nextLine();
                boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
                listOfToppings.add(new Sauce(name, wantsExtra));
                System.out.println("Sauce topping added successfully");
                return;
            }
            System.err.println("Invalid choice for sauce");
        }
    }

    public void processSideChoice(Scanner scanner) {
        while (true) {
            int sideChoice = InputValidation.parseInt("""
                    Sides
                    1 - sauce
                    2 - au jus
                    99 - back""", scanner);
            if (sideChoice == 99) return;

            String name;
            switch (sideChoice) {
                case 1 -> name = "sauce";
                case 2 -> name = "au jus";
                default -> name = "";
            }
            if(!name.isEmpty()) {
                System.out.println("Do you want extra sides?\nType yes if you do, any other input defaults to no");
                String choiceExtra = scanner.nextLine();
                boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
                listOfToppings.add(new Side(name, wantsExtra));
                System.out.println("Side has been added successfully");
                return;
            }
            System.err.println("Please enter a valid choice.");
        }
    }

    @Override
    public double getCost(){
        double totalCost = 0;
        switch(size){
            case 4 -> totalCost += 5.50;
            case 8 -> totalCost += 7.00;
            case 12 -> totalCost += 8.50;
            default -> System.err.println("You did not order a sandwich.");
        }
        totalCost = listOfToppings.stream()
                .map(Topping::getCost)
                .reduce(totalCost, Double::sum);
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Topping topping : listOfToppings){
            String extraTopping = "";
            if(topping.isExtra()){
                extraTopping = "(extra)";
            }
            sb.append(topping.getName()).append(extraTopping).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        String isToastedConvert = isToasted() ? "(Toasted)" : "";
        return getName() + isToastedConvert + ": $" + String.format("%.2f", getCost()) + "\nBread Type: " + breadType + "\nSize: " + size + "\nToppings: " + sb + "\n";
    }
}
