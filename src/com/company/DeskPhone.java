package com.company;

public class DeskPhone implements Telephone{
    @Override
    public void powerOn() {
        System.out.println("There is no button, its always on");
    }

    @Override
    public void dial(int phoneNumber) {

    }

    @Override
    public void answer() {

    }

    @Override
    public boolean callPhone(int phoneNumber) {
        return false;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
