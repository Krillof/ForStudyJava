package com.study.Lesson15_06;

import java.util.ArrayList;

public class SumInThread extends Thread{
    private ArrayList<Integer> arr;
    private JustObjectForTransfering jjj;

    public SumInThread(ArrayList<Integer> arr, JustObjectForTransfering jjj){
        this.arr = arr;
        this.jjj = jjj;
    }

    public void run(){
        int sum = 0;
        for (int f = 0; f < arr.size(); f++){
            sum += arr.get(f);
        }
        jjj.value = sum;
    }
}
