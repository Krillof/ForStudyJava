package com.study.Lesson15_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteInFileEvenThread extends Thread{
    private ArrayList<Integer> arr;
    private JustObjectForTransfering jjj;
    private String filename;

    public WriteInFileEvenThread(ArrayList<Integer> arr, JustObjectForTransfering jjj, String filename){
        this.arr = arr;
        this.jjj = jjj;
        this.filename = filename;
    }

    public void run(){
        int amount = 0;
        File file = new File(filename);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file.getParent() + "/" + file.getName()));
            for (int f = 0; f < arr.size(); f++){
                int m = arr.get(f);
                if (m%2 == 0) {
                    amount++;
                    out.write(m + "\n");
                }
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jjj.value = amount;
    }
}
