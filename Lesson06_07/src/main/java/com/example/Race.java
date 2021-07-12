package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Race {
    private Car car1;
    private Car car2;
    private Car car3;

    @Autowired
    public Race(@Qualifier("truck") Car car1, @Qualifier("sportCar") Car car2, @Qualifier("jeep") Car car3){
        this.car1 = car1;
        this.car2 = car2;
        this.car3 = car3;
    }

    public enum CarsTypes{
        truck,
        jeep,
        sport
    }



    public String getWinner(CarsTypes t){
        ArrayList<String> cars = new ArrayList<>();
        switch (t){

            case truck:
                for (String m : car1.getModels()){
                    cars.add(m);
                }
                break;
            case jeep:
                for (String m : car3.getModels()){
                    cars.add(m);
                }
                break;
            case sport:
                for (String m : car2.getModels()){
                    cars.add(m);
                }
                break;
        }



        Random rand = new Random();
        return cars.get(rand.nextInt(cars.size()));
    }

}
