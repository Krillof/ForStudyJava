package com.study.Lesson15_06;

import java.util.ArrayList;

public class MaxInThread extends Thread{
    private ArrayList<Integer> arr;
    private JustObjectForTransfering jjj;

    public MaxInThread(ArrayList<Integer> arr, JustObjectForTransfering jjj){
        this.arr = arr;
        this.jjj = jjj;
    }

    public void run(){
        int max = Integer.MIN_VALUE;
        for (int f = 0; f < arr.size(); f++){
            int m = arr.get(f);
            if (m > max) max = m;
        }
        jjj.value = max;
    }
}
