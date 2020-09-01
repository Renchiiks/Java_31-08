package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dog implements Saveable {
    private String name;
    private boolean isBarking;

    public Dog(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBarking() {
        return isBarking;
    }

    public void setBarking(boolean barking) {
        isBarking = barking;
    }


    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, Boolean.toString(isBarking));
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues.size() > 0) {
            name = savedValues.get(0);
            isBarking = Boolean.getBoolean(savedValues.get(1));
        }
    }
}
