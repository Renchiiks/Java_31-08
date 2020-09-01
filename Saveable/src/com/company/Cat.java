package com.company;


import java.util.ArrayList;
import java.util.List;

public class Cat implements Saveable {
    private String name;
    private boolean isMurmur;


    public Cat(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMurmur() {
        return isMurmur;
    }

    public void setMurmur(boolean murmur) {
        isMurmur = murmur;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isMurmur=" + isMurmur +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0, name);
        values.add(1, "" + Boolean.toString(isMurmur));
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if (savedValues.size() > 0) {
            name = savedValues.get(0);
            isMurmur = Boolean.getBoolean(savedValues.get(1));
        }
    }
}
