package com.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SportCar implements Car{

    ArrayList<String> cars = new ArrayList<>();
    {
        cars.add("s1");
        cars.add("s2");
        cars.add("s3");
    }

    @Override
    public ArrayList<String> getModels() {
        return cars;
    }

    @Override
    public int getSpeed() {
        return 200;
    }

}
