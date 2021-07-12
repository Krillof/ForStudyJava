package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Race {
    @Autowired
    private Car car;//Рефлексия

    public void racer() {
        System.out.println(car.getSpeed());
        }
}
