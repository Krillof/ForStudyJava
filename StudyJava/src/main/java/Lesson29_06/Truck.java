package Lesson29_06;

public class Truck implements Car {

    public void initMethod(){
        System.out.println("Truck was made");
    }

    public void destroyMethod(){
        System.out.println("Truck was destroyed");
    }

    @Override
    public int getSpeed() {
        return 70;
    }
}
