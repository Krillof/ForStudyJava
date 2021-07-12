package org.example;

import org.springframework.stereotype.Component;

//@Component("jBean")
public class Jeep implements Car {


    @Override
    public int getSpeed() {
        return 120;
    }
}
