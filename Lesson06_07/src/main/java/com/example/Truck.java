package com.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Truck implements Car {
    ArrayList<String> cars = new ArrayList<>();
    {
        cars.add("t1");
        cars.add("t2");
        cars.add("t3");
    }


    @Override
    public ArrayList<String> getModels() {
        return cars;
    }

    @Override
    public int getSpeed() {
        return 70;
    }


}
