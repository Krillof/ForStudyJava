package com.study.Lesson09_06;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        /*
        Test test;
        test = ()->3;

        System.out.println(test.f());

         */

        A a = (x, y, z) -> x+y+z;
        B b = (x, y, z) -> x*y*z;
        C c = ()-> LocalTime.now();
        D d = ()-> LocalDate.now();

        System.out.println(a.Sum(1, 2, 3));
        System.out.println(b.Multiply(1, 2, 3));
        System.out.println(c.GetTime());
        System.out.println(d.GetDate());


        //-----------------------------------------
        System.out.println("---------------------------");

        E e = (x, y)->{
          if (x>y) return x;
          else return y;
        };

        F f = (x, y)->{
            if (x<y) return x;
            else return y;
        };

        G g = (x)->{
          int y = 1;
          while (x != 1){
              y *= x;
              x--;
          }
          return y;
        };

        H h = (x) -> {
            for (int i = 2; i < x; i++){
                if (x%i == 0){
                    return false;
                }
            }
            return true;
        };


        //-----------------------------------------
        System.out.println("---------------------------");

        I i = (x, y, z) -> {
          boolean xy = x>y;
          boolean yz = y>z;
          boolean xz = x>z;
          if (xy)
                if (xz) return x;
                else return z;
          else
                if (yz) return y;
                else return z;
        };

        J j = (x, y, z) -> {
            boolean xy = x<y;
            boolean yz = y<z;
            boolean xz = x<z;
            if (xy)
                if (xz) return x;
                else return z;
            else
            if (yz) return y;
            else return z;
        };

        //-----------------------------------------
        System.out.println("---------------------------");

        K k = (x) ->{
            return x%2 == 0;
        };

        L l = (x) ->{
            return x%2 == 1;
        };

        M m = (x, y, z) ->{
            return (y <= x) && (x <= z);
        };

        N n = (x, y) ->{
            return x%y == 0;
        };


        //--------------------------------
        System.out.println("---------------------------");
        WorkingWithFiles wwf = new WorkingWithFiles();
        System.out.println(wwf.f3("123"));
        System.out.println(wwf.f3("abc"));

        //wwf.f5("456", "1");

        /*
        System.out.println(wwf.f6("/home/krilof/IdeaProjects/JustPractice09_06/src/1.txt",
                "/home/krilof/IdeaProjects/JustPractice09_06/src/2.txt",
                "/home/krilof/IdeaProjects/JustPractice09_06/src/3.txt",
                "/home/krilof/IdeaProjects/JustPractice09_06/src/4.txt"));

         */

        ArrayList<String> arr = new ArrayList<String>();
        arr.add("abc");
        arr.add("1");

        wwf.f7(arr, "#");
    }
}
