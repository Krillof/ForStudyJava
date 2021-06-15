package com.study.Lesson15_06;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException  {
        //f1();
        //f2();
        //f3();
        //f4();

        //g1();
        //g2();
        //g3();
        g4();
    }

    private static void f1() throws InterruptedException {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(5);
        arr.add(15);

        JustObjectForTransfering j1 =  new JustObjectForTransfering();
        JustObjectForTransfering j2 = new JustObjectForTransfering();

        MaxInThread mit = new MaxInThread(arr, j1);
        MinInThread mit2 = new MinInThread(arr, j2);
        mit.start();
        mit2.start();

        mit.join();
        mit2.join();

        System.out.println((int)j1.value);
        System.out.println((int)j2.value);
    }

    private static void f2() throws InterruptedException{
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(5);
        arr.add(15);

        JustObjectForTransfering j1 =  new JustObjectForTransfering();
        JustObjectForTransfering j2 = new JustObjectForTransfering();

        SumInThread mit = new SumInThread(arr, j1);
        AverageInThread mit2 = new AverageInThread(arr, j2);
        mit.start();
        mit2.start();

        mit.join();
        mit2.join();

        System.out.println((int)j1.value);
        System.out.println((int)j2.value);
    }

    private static void f3() throws IOException, InterruptedException {
        File file = new File("/home/krilof/IdeaProjects/StudyJava/src/main/java/com/study/Lesson15_06/1.txt");
        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        ArrayList<Integer> arr = new ArrayList<>();
        String line = in.readLine();
        while(line != null) {
            arr.add(Integer.parseInt(line));
            line = in.readLine();
        }
        in.close();

        JustObjectForTransfering j1 =  new JustObjectForTransfering();
        JustObjectForTransfering j2 = new JustObjectForTransfering();

        WriteInFileOddThread mit = new WriteInFileOddThread(arr, j1,
                "/home/krilof/IdeaProjects/StudyJava/src/main/java/com/study/Lesson15_06/2.txt");
        WriteInFileEvenThread mit2 = new WriteInFileEvenThread(arr, j2,
                "/home/krilof/IdeaProjects/StudyJava/src/main/java/com/study/Lesson15_06/3.txt");
        mit.start();
        mit2.start();

        mit.join();
        mit2.join();

        System.out.println((int)j1.value);
        System.out.println((int)j2.value);

    }

    private static void f4() throws InterruptedException{
        JustObjectForTransfering j1 =  new JustObjectForTransfering();
        JustObjectForTransfering j2 = new JustObjectForTransfering();

        FindWord mit = new FindWord(j1,
                "/home/krilof/IdeaProjects/StudyJava/src/main/java/com/study/Lesson15_06/text.txt", "text");
        FindWord mit2 = new FindWord(j2,
                "/home/krilof/IdeaProjects/StudyJava/src/main/java/com/study/Lesson15_06/text.txt", "left");
        mit.start();

        mit.join();
        mit2.start();

        mit2.join();

        if ((boolean)j1.value) System.out.println("1: yes");
        else System.out.println("1: no");

        if ((boolean)j2.value) System.out.println("2: yes");
        else System.out.println("2: no");
    }

    private static void g1(){
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random();
        for (int f = 0; f < 10; f++){
            int n = rand.nextInt(20)-10;
            arr.add(n);
            System.out.print(n + "   ");
        }
        System.out.println(" ");

        long evenAmount = arr.stream().filter(a -> a%2 == 0).count();
        System.out.println(evenAmount);
        long oddAmount = arr.stream().filter(a -> a%2 == 1).count();
        System.out.println(oddAmount);
        long zeroAmount = arr.stream().filter(a -> a == 0).count();
        System.out.println(zeroAmount);
        long myValueAmount = arr.stream().filter(a -> a == 1).count();
        System.out.println(myValueAmount);
    }

    private static void g2() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Moscow");
        arr.add("Moscow");
        arr.add("Krasnodar");
        arr.add("Sochi");
        arr.add("Saint-Petersburg");
        arr.add("Volgograd");
        arr.add("Volgograd");

        arr.forEach(a-> System.out.print(a + "   "));
        System.out.println(" ");
        arr.forEach(a->{
            if (a.length() > 6) System.out.print(a + "   ");
        });
        System.out.println(" ");
        System.out.println(arr.stream().filter(a -> a.equals("Moscow")).count());
        arr.forEach(a->{
            if (a.charAt(0) == 'S') System.out.print(a + "   ");
        });
        System.out.println(" ");
    }

    private static void g3() {
        ArrayList<Car> arr = new ArrayList<>();
        arr.add(new Car("1", 1902, 100, "red", 100));
        arr.add(new Car("1", 1932, 1000, "green", 1000));
        arr.add(new Car("2", 2002, 10000, "red", 1000));
        arr.add(new Car("3", 2012, 10000, "cyan", 100));
        arr.add(new Car("4", 2005, 1000, "green", 10));


        arr.forEach(Car::show);
        System.out.println("------------------------");
        arr.stream().filter(a->a.color.equals("red")).forEach(Car::show);
        System.out.println("------------------------");
        arr.stream().filter(a->a.volumeOfEngine == 100).forEach(Car::show);
        System.out.println("------------------------");
        arr.stream().filter(a->a.price > 100).forEach(Car::show);
        System.out.println("------------------------");
        arr.stream().filter(a-> a.year < 2010 && a.year > 2000).forEach(Car::show);
        System.out.println("------------------------");
    }

    private static void g4(){
        ArrayList<TV> arr = new ArrayList<>();
        arr.add(new TV("1", 1950, 100, 5, "3"));
        arr.add(new TV("2", 1950, 1000, 4, "1"));
        arr.add(new TV("3", 1960, 10000, 3, "2"));
        arr.add(new TV("4", 1965, 10000, 3, "1"));
        arr.add(new TV("5", 1960, 1000, 4, "2"));
        arr.add(new TV("6", 1975, 100, 5, "1"));

        arr.forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().filter(a->a.d == 4).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().filter(a->a.producer.equals("1")).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().filter(a->a.year == 1960).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().filter(a->a.price > 1000).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().sorted((a,b)->{
            if (a.price-b.price > 0){
                return 1;
            } else if (a.price == b.price){
                return 0;
            } else return -1;
        }).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().sorted((a,b)->{
            if (a.price-b.price < 0){
                return 1;
            } else if (a.price == b.price){
                return 0;
            } else return -1;
        }).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().sorted((a,b)->{
            if (a.d-b.d > 0){
                return 1;
            } else if (a.d == b.d){
                return 0;
            } else return -1;
        }).forEach(TV::show);
        System.out.println("--------------------------");
        arr.stream().sorted((a,b)->{
            if (a.d-b.d < 0){
                return 1;
            } else if (a.d == b.d){
                return 0;
            } else return -1;
        }).forEach(TV::show);
        System.out.println("--------------------------");
    }
}
