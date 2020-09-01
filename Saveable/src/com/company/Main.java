package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Muris");
        System.out.println(cat.toString());
        saveObject(cat);

        cat.setMurmur(true);
        System.out.println(cat);
        saveObject(cat);
        loadObject(cat);
        System.out.println(cat);
    }

    private static void saveObject(Saveable saveable) {
        for (int i = 0; i < saveable.write().size(); i++) {
            System.out.println("Saving " + saveable.write().get(i) + " to Storage Device");

        }

    }

    private static void loadObject(Saveable saveable) {
        List<String> values = readValues();
        saveable.read(values);

    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

}
