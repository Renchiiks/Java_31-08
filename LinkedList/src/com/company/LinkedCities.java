package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedCities {
    public static void main(String[] args) {
        LinkedList<String> citiesToVisit = new LinkedList<>();

        addInOrder(citiesToVisit, "Riga");
        addInOrder(citiesToVisit, "Jurmala");
        addInOrder(citiesToVisit, "Valmiera");
        addInOrder(citiesToVisit, "Liepaja");
        addInOrder(citiesToVisit, "Ventspils");
        addInOrder(citiesToVisit, "Preili");
        addInOrder(citiesToVisit, "Saulkrasti");

        printCities(citiesToVisit);

        addInOrder(citiesToVisit, "Riga");
        addInOrder(citiesToVisit, "Valka");

        visit(citiesToVisit);


    }

    private static void printCities(LinkedList<String> citiesToVisit) {
        Iterator<String> i = citiesToVisit.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void addInOrder(LinkedList<String> linkedList, String cityName) {
        ListIterator<String> i = linkedList.listIterator();

        while (i.hasNext()) {
            int comparison = i.next().compareTo(cityName);
            if (comparison == 0) {
                System.out.println("City is already in the list");

            } else if (comparison > 0) {
                i.previous();
                i.add(cityName);
                System.out.println("City set in order to list");


            }

        }

        linkedList.add(cityName);
        System.out.println("City added to list");

    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> i = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in itinerary");

        } else {
            System.out.println("New visiting " + i.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                case 1:
                    if (!goingForward) {
                        if (i.hasNext()) {
                            i.next();
                        }
                        goingForward = true;
                    }

                    if (i.hasNext()) {
                        System.out.println("Now visiting " + i.next());
                    } else {
                        System.out.println("Reached end of the list");
                        goingForward = false;
                    }

                    break;
                case 2:
                    if (goingForward) {
                        if (i.hasPrevious()) {
                            i.previous();
                        }
                        goingForward = false;
                    }

                    if (i.hasPrevious()) {
                        System.out.println("Now visiting " + i.previous());
                    } else {
                        System.out.println("We reached the start of the list");
                    }

                    goingForward = true;
                    break;

                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: press ");
        System.out.println("0 - To quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print options");
    }
}
