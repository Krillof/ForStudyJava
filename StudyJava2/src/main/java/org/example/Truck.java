package org.example;

import org.springframework.stereotype.Component;

@Component("truckBean")
public class Truck implements Car {

    @Override
    public int getSpeed() {
        return 70;
    }
}
