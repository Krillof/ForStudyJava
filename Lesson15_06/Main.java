package com.study.Lesson15_06;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException  {
        //f1();
        //f2();
        //f3();
        f4();
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
}
