package com.company;

public class MobilePhone implements Telephone {

    private int phoneNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Phone is on");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("Dial number " + phoneNumber);
        } else {
            System.out.println("Need to turn on the phone");
        }
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
        if (phoneNumber == this.phoneNumber && this.isOn) {
            System.out.println("Someone is calling");
            isRinging = true;
        }else {
            System.out.println("Wrong number");
            isRinging = false;
        }

        return isRinging;

    }

    @Override
    public boolean isRinging() {
        if(callPhone(this.phoneNumber)){
            isRinging = true;
        }else {
            isRinging = false;
        }
      return isRinging;
    }
}
