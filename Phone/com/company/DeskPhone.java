package com.company;

public class DeskPhone implements Telephone {

    private int phoneNumber;
    private boolean isRinging;

    public DeskPhone(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("There is no button, its always on");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber + "on desk phone");
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answer the phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == this.phoneNumber) {
            isRinging = true;
            System.out.println("Ringing");
        } else {
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        if (callPhone(phoneNumber)) {
            answer();
            isRinging = false;
        } else {
            isRinging = true;
        }
        return isRinging;
    }
}
