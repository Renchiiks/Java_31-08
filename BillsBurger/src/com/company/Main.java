package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Which burger?");

        printBurgerOptions();
        String burgerOption = sc.nextLine();
        int optionNumber = Integer.parseInt(burgerOption);

        String bread = null;
        if (Burger.doesRequireBread(optionNumber)) {
            System.out.println("Which bread?");
            bread = sc.next();
        }

        System.out.println("Which meat?");
        String meat = sc.next();

        int numberOfAdditions = 0;
        if (Burger.doesRequireAdditions(optionNumber)) {
            System.out.println("How much additions?");
            String numberString = sc.next();
            numberOfAdditions = Integer.parseInt(numberString);
        }

        Burger burger = createBurger(optionNumber, bread, meat, numberOfAdditions);

        String addition = null;
        double priceForAddition = 0;

        if (Burger.doesRequireAdditions(optionNumber)) {
            for (int i = 1; i <= burger.getNumberOfAdditions(); i++) {
                System.out.println("What kind of additions you what?");
                addition = sc.next();
                System.out.println("On how much price add " + addition);
                String priceString = sc.next();
                priceForAddition = Double.parseDouble(priceString);

                burger.addAddition(addition, priceForAddition);
            }
        }else {
            burger.addAddition("Drink", 0.9);
            burger.addAddition("Chips", 1.09);
        }
        System.out.println(burger.toString());

    }

    private static Burger createBurger(int burgerOption, String bread, String meat, int numberOfAdditions) {
        return switch (burgerOption) {
            case 1 -> new Burger(bread, meat, numberOfAdditions);
            case 2 -> new HealthyBurger(meat, numberOfAdditions);
            case 3 -> new DeluxeBurger(bread, meat);
            default -> null;
        };
    }

    private static void printBurgerOptions() {
        System.out.println("1 - Burger\n" +
                "2 - Healthy Burger\n" +
                "3 - Deluxe Burger\n" +
                "4 - None");
    }

}
