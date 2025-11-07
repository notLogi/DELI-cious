package com.pluralsight.product;

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

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void addTopping(Scanner scanner){
        while(true){
            System.out.println("What toppings do you want? Type 1-5, meat, cheese, vegetables, sauces, and sides, respectively.\nType 99 to back");
            int choice = scanner.nextInt();
            if(choice == 99){
                return;
            }
            switch(choice) {
                case 1 -> processMeatChoice(scanner);
                case 2 -> processCheeseChoice(scanner);
                case 3 -> processVegetableChoice(scanner);
                case 4 -> processSauceChoices(scanner);
                case 5 -> processSideChoices(scanner);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void processMeatChoice(Scanner scanner){
        System.out.println("Meats:");
        System.out.println("""
                            1 - steak
                            2 - ham
                            3 - salami
                            4 - roast beef
                            5 - chicken
                            6 - bacon
                            99 - back""");
        int meatChoice = scanner.nextInt();
        scanner.nextLine();
        if(meatChoice == 99)
            return;
        String name;
        switch(meatChoice){
            case 1 -> name = "steak";
            case 2 -> name = "ham";
            case 3 -> name = "salami";
            case 4 -> name = "roast beef";
            case 5 -> name = "chicken";
            case 6 -> name = "bacon";
            default -> name = "";
        }
        System.out.println("Do you want extra meat?\nType yes if you do, leave blank if you don't");
        String choiceExtra = scanner.nextLine();
        boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
        if(!name.isEmpty()){
            listOfToppings.add(new Meat(name, size, wantsExtra));
            System.out.println("Meat topping added successfully");
            return;
        }
        System.out.println("Invalid choice for meat");
    }

    public void processCheeseChoice(Scanner scanner){
        System.out.println("Cheeses");
        System.out.println("""
                            1 - american
                            2 - provolone
                            3 - cheddar
                            4 - swiss
                            99 - back""");
        int cheeseChoice = scanner.nextInt();
        scanner.nextLine();
        if (cheeseChoice == 99)
            return;
        String name;
        switch(cheeseChoice){
            case 1 -> name = "american";
            case 2 -> name = "provolone";
            case 3 -> name = "cheddar";
            case 4 -> name = "swiss";
            default -> name = "";
        }
        System.out.println("Do you want extra cheese?\nType yes if you do, leave blank if you don't");
        String choiceExtra = scanner.nextLine();
        boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
        if(!name.isEmpty()){
            listOfToppings.add(new Cheese(name, size, wantsExtra));
            System.out.println("Cheese topping added successfully");
            return;
        }
        System.out.println("Invalid choice for cheese");
    }

    public void processVegetableChoice(Scanner scanner){
        System.out.println("Vegetables");
        System.out.println("""
                        1 - lettuce
                        2 - peppers
                        3 - onions
                        4 - tomatoes
                        5 - jalapenos
                        6 - cucumbers
                        7 - pickles
                        8 - guacamole
                        9 - mushrooms
                        99 - back""");
        int vegetableChoice = scanner.nextInt();
        scanner.nextLine();
        if (vegetableChoice == 99)
            return;
        String name;
        switch(vegetableChoice){
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
        System.out.println("Do you want extra veggies?\nType yes if you do, leave blank if you don't");
        String choiceExtra = scanner.nextLine();
        boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
        if(!name.isEmpty()){
            listOfToppings.add(new Vegetable(name, wantsExtra));
            System.out.println("Veggie topping added successfully");
            return;
        }
        System.out.println("Invalid choice for veggies");
    }

    public void processSauceChoices(Scanner scanner){
        System.out.println("Sauces");
        System.out.println("""
                        1 - mayo
                        2 - ketchup
                        3 - ranch
                        4 - thousand islands
                        5 - vinaigrette
                        99 - back""");
        int sauceChoice = scanner.nextInt();
        scanner.nextLine();
        if (sauceChoice == 99)
            return;
        String name;
        switch(sauceChoice){
            case 1 -> name = "mayo";
            case 2 -> name = "ketchup";
            case 3 -> name = "ranch";
            case 4 -> name = "thousand islands";
            case 5 -> name = "vinaigrette";
            default -> name = "";
        }
        System.out.println("Do you want extra sauce?\nType yes if you do, leave blank if you don't");
        String choiceExtra = scanner.nextLine();
        boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
        if(!name.isEmpty()){
            listOfToppings.add(new Sauce(name, wantsExtra));
            System.out.println("Sauce topping added successfully");
            return;
        }
        System.out.println("Invalid choice for sauce");
    }

    public void processSideChoices(Scanner scanner){
        System.out.println("Sides");
        System.out.println("""
                        1 - sauce
                        2 - au jus
                        99 - back""");
        int sideChoice = scanner.nextInt();
        scanner.nextLine();
        if (sideChoice == 99)
            return;
        String name;
        switch(sideChoice){
            case 1 -> name = "mayo";
            case 2 -> name = "ketchup";
            case 3 -> name = "ranch";
            case 4 -> name = "thousand islands";
            case 5 -> name = "vinaigrette";
            default -> name = "";
        }
        System.out.println("Do you want extra sides?\nType yes if you do, leave blank if you don't");
        String choiceExtra = scanner.nextLine();
        boolean wantsExtra = choiceExtra.equalsIgnoreCase("yes");
        if(!name.isEmpty()){
            listOfToppings.add(new Side(name, wantsExtra));
            System.out.println("Side has been added successfully");
            return;
        }
        System.out.println("Invalid choice for side");
    }

    @Override
    public double getCost(){
        double totalCost = 0;
        switch(size){
            case 4 -> totalCost += 5.50;
            case 8 -> totalCost += 7.00;
            case 12 -> totalCost += 8.50;
            default -> System.out.println("You did not order a sandwich.");
        }
        totalCost = listOfToppings.stream()
                .map(Topping::getCost)
                .reduce(totalCost, Double::sum);
        return totalCost;
    }
}
