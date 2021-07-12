package org.example;

import org.springframework.stereotype.Component;

//@Component("spcBean")
public class SportCar implements Car{

    @Override
    public int getSpeed() {
        return 200;
    }
}
