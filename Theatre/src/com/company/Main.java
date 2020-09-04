package com.company;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Theatre", 8, 12);
        theatre.getSeats();

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry seat is taken or doesn't exist");
        }

        if(theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry seat is taken or doesn't exist");
        }
    }
}
