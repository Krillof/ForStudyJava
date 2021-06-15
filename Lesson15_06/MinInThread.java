package com.study.Lesson15_06;

import java.util.ArrayList;

public class MinInThread extends Thread{
    private ArrayList<Integer> arr;
    private JustObjectForTransfering jjj;

    public MinInThread(ArrayList<Integer> arr, JustObjectForTransfering jjj){
        this.arr = arr;
        this.jjj = jjj;
    }

    public void run(){
        int min = Integer.MAX_VALUE;
        for (int f = 0; f < arr.size(); f++){
            int m = arr.get(f);
            if (m < min) min = m;
        }

        jjj.value = min;
    }
}
