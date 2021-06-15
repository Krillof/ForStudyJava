package com.study.Lesson15_06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindWord extends Thread{
    private JustObjectForTransfering jjj;
    private String filename;
    private String word;

    public FindWord(JustObjectForTransfering jjj, String filename, String word){
        this.jjj = jjj;
        this.filename = filename;
        this.word = word;
    }

    public void run(){
        boolean isThere = false;
        File file = new File(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" + file.getName()));
            String line = in.readLine();
            String text = "";
            while (line != null) {
                text += line;
                line = in.readLine();
            }
            in.close();

            isThere = text.contains(this.word);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jjj.value = isThere;

    }
}
