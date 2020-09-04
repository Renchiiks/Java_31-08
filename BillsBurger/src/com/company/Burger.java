package com.company;

import java.util.ArrayList;

public class Burger {
    private String bread;
    private String meat;
    private double basePrice;

    private double finalPrice;
    private int numberOfAdditions;
    private int maxAdditions = 4;
    private ArrayList<AdditionalItem> additionalItems= new ArrayList<>();

    public Burger(String bread, String meat, double basePrice, int numberOfAdditions, int maxAdditions) {
        this.bread = bread;
        this.meat = meat;
        this.basePrice = basePrice;
        if (numberOfAdditions > maxAdditions) {
            this.numberOfAdditions = maxAdditions;
            System.out.println("This burger can have only " + maxAdditions + " additions");

        } else {
            this.numberOfAdditions = numberOfAdditions;
        }
        this.maxAdditions = maxAdditions;
    }

    public Burger(String bread, String meat, int numberOfAdditions) {
        this.bread = bread;
        this.meat = meat;
        this.basePrice = 2.07;

        if (numberOfAdditions > maxAdditions) {
            this.numberOfAdditions = maxAdditions;
            System.out.println("This burger can have only " + maxAdditions + " additions");

        } else {
            this.numberOfAdditions = numberOfAdditions;
        }
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public ArrayList<AdditionalItem> getAdditionalItems() {
        return additionalItems;
    }

    public int getNumberOfAdditions() {
        return numberOfAdditions;
    }

    public static boolean doesRequireBread(int option) {
        return switch (option) {
            case 1, 3 -> true;
            default -> false;
        };
    }
    public static boolean doesRequireAdditions(int option){
        return switch (option){
            case 1,2 -> true;
            default -> false;
        };
    }

    public void addAddition(String name, double price) {
        for (int i = 0; i < this.numberOfAdditions; i++) {
            additionalItems.add(new AdditionalItem(name, price));
            System.out.println(name + " added to the burger");

        }

        calculatePrice();
    }

    public void calculatePrice() {

        for (AdditionalItem item : additionalItems) {
            this.finalPrice += item.getPrice();
        }

        this.finalPrice += this.basePrice;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bread='" + bread + '\'' +
                ", meat='" + meat + '\'' +
                ", basePrice=" + basePrice +
                ", finalPrice=" + finalPrice +
                ", numberOfAdditions=" + numberOfAdditions +
                ", additionalItems=" + additionalItems.toString() +
                '}';
    }
}

