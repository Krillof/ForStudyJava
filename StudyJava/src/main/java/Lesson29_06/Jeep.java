package Lesson29_06;

public class Jeep implements Car {

    private Jeep(){}

    public static Jeep getJeep(){
        return new Jeep();
    }

    @Override
    public int getSpeed() {
        return 120;
    }
}
