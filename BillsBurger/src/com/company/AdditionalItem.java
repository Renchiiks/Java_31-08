package com.company;

public class AdditionalItem {
    private String name;
    private double price;

    public AdditionalItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static AdditionalItem createItem(String name, double price) {
        return new AdditionalItem(name, price);
    }

    @Override
    public String toString() {
        return "AdditionalItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
