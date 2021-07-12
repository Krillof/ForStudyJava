package org.example;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class TestSpring {
    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );


        /*
         //if @Component on all Car childs
        Car car = context.getBean("truck", Car.class);
        Car car1 = context.getBean("spcBean", Car.class);
        Car car2 = context.getBean("jBean", Car.class);
        Race race = new Race(car);
        Race race1 = new Race(car1);
        Race race2 = new Race(car2);
        race.racer();
        race1.racer();
        race2.racer();
        */

        Race race = context.getBean("race", Race.class);
        race.racer();



        context.close();
    }
}
