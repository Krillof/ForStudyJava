package com.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("singleton")
public class Jeep implements Car {

    ArrayList<String> cars = new ArrayList<>();
    {
        cars.add("j1");
        cars.add("j2");
        cars.add("j3");
    }

    @Override
    public ArrayList<String> getModels() {
        return cars;
    }

    @Override
    public int getSpeed() {
        return 120;
    }

}
