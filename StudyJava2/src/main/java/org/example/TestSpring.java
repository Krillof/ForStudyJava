package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Car car = context.getBean("truckBean", Car.class);

        Race race = new Race(car);

        race.racer();


        context.close();
    }
}
