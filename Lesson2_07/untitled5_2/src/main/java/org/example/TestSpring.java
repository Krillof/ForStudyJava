package org.example;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class TestSpring {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Race race = (Race)context.getBean("race");

        System.out.println(race.getWinner(Race.CarsTypes.truck));
        System.out.println(race.getWinner(Race.CarsTypes.jeep));
        System.out.println(race.getWinner(Race.CarsTypes.sport));

        System.out.println(race.color);

        context.close();
    }
}
