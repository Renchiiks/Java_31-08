package com.company;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName()+ "is swallowing");
    }

    @Override
    public void fly() {
        System.out.println("No thank you");
    }
}
