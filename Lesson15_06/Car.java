package com.study.Lesson15_06;

public class Car {
    public String name;
    public int year;
    public int price;
    public String color;
    public int volumeOfEngine;

    public Car(String name, int year, int price, String color, int volumeOfEngine){

        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.volumeOfEngine = volumeOfEngine;
    }

    public void show(){
        System.out.print("[");
        System.out.print(name+", ");
        System.out.print(year+",");
        System.out.print(price+",");
        System.out.print(color+",");
        System.out.println(volumeOfEngine+"]");
    }
}
