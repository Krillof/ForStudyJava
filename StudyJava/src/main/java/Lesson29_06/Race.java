package Lesson29_06;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> carList = new ArrayList<>();


    private String model;
    private String color;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void racer() {
        for (Car car:carList) {
            System.out.println(car.getSpeed());
        }
    }
}
