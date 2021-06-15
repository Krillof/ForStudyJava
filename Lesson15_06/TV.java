package com.study.Lesson15_06;

public class TV {
    public String name;
    public int year;
    public int price;
    public int d;
    public String producer;

    public TV(String name, int year, int price, int d, String producer){

        this.name = name;
        this.year = year;
        this.price = price;
        this.d = d;
        this.producer = producer;
    }

    public void show(){
        System.out.print("[");
        System.out.print(name+", ");
        System.out.print(year+",");
        System.out.print(price+",");
        System.out.print(d+",");
        System.out.println(producer+"]");
    }
}
