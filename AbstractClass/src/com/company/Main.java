package com.company;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Reno");
        dog.breathe();
        dog.eat();

        Parrot parrot = new Parrot("Talky");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Swimmy");
        penguin.breathe();
        penguin.eat();
        penguin.fly();
    }
}
