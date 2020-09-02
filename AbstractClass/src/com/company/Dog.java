package com.company;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " eats");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing");
    }
}
