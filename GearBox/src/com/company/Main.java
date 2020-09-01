package com.company;

public class Main {

    public static void main(String[] args) {

        GearBox bmw = new GearBox(5);

        bmw.operateClutch(true);
        bmw.changeGear(1);
        System.out.println(bmw.wheelSpeed(1000));
        bmw.operateClutch(false);
        bmw.changeGear(2);
        System.out.println(bmw.wheelSpeed(3000));
        bmw.operateClutch(true);
        bmw.changeGear(3);
        System.out.println(bmw.wheelSpeed(5000));

    }
}
