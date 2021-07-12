package org.example;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private Car car;

    public Race(Car car){
        this.car = car;
    }


    public void racer() {
         System.out.println(car.getSpeed());
    }
}
