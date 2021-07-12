package Lesson29_06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
/*
//        Car car = context.getBean("sportCar",Car.class);
//        Race race = new Race(car);

        Race race = context.getBean("raceList", Race.class);

        race.racer();

        System.out.println(race.getModel());
        System.out.println(race.getColor());

*/


        Truck truck = context.getBean("carBean", Truck.class);
        Truck truck2 = context.getBean("carBean2", Truck.class);

        System.out.println(truck.getSpeed());
        System.out.println(truck2.getSpeed());



        Jeep jeep = context.getBean("jBean", Jeep.class);
        Jeep jeep2 = context.getBean("jBean", Jeep.class);
        System.out.println(jeep);//jeep == jeep2   = true
        System.out.println(jeep2);




        context.close();
    }
}
