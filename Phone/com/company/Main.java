package com.company;

public class Main {

    public static void main(String[] args) {

        Telephone telephone;
        telephone = new DeskPhone(68464);
        telephone.powerOn();
        telephone.dial(4674687);
        telephone.isRinging();

    }
}
