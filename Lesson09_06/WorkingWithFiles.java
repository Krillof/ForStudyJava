package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WorkingWithFiles {

    File file;

    public WorkingWithFiles(){
        file = new File("/home/krilof/IdeaProjects/JustPractice09_06/src/test.txt");
    }

    public void f1() throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();
        while(line != null) {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();
    }

    public int f3(String word) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();

        int count = 0;

        while(line != null) {

            int c = 0;
            c = line.indexOf(word, c);
            while (c!=-1){
                count++;
                c = line.indexOf(word, c+1);
            }


            line = in.readLine();
        }
        in.close();

        return count;
    }

    public class Counted{
        public int Numbers = 0;
        public int Symbols = 0;
        public int Letters = 0;
    }

    public Counted f4() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();

        Counted counted = new Counted();

        while(line != null) {

            for (int f = 0; f < line.length(); f++){
                if (Character.isLetter(line.charAt(f))) counted.Letters++;
                else if (Character.isDigit(line.charAt(f))) counted.Numbers++;
                else counted.Symbols++;
            }

            line = in.readLine();
        }
        in.close();

        return counted;
    }

    public void f5(String from_word, String to_word) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();

        String file_text = "";

        while(line != null) {
            file_text += (line + "\n");
            line = in.readLine();
        }
        in.close();

        file_text = file_text.replace(from_word, to_word);

        BufferedWriter out = new BufferedWriter(new FileWriter(file.getParent() + "/" + file.getName()));
        out.write(file_text);
        out.close();
    }

    public int f6(String file1, String file2, String file3, String file4) throws IOException {
        File file_1 = new File(file1);
        File file_2 = new File(file2);
        File file_3 = new File(file3);
        File file_4 = new File(file4);

        int chars = 0;


        BufferedReader in = new BufferedReader(new FileReader(file_1.getParent() + "/" +  file_1.getName()));
        String line = in.readLine();

        String res_text = "";

        while(line != null) {
            res_text += (line + "\n");
            chars += line.length();
            line = in.readLine();
        }
        in.close();



         in = new BufferedReader(new FileReader(file_2.getParent() + "/" +  file_2.getName()));
        line = in.readLine();

        while(line != null) {
            res_text += (line + "\n");
            chars += line.length();
            line = in.readLine();
        }
        in.close();




         in = new BufferedReader(new FileReader(file_3.getParent() + "/" +  file_3.getName()));
        line = in.readLine();

        while(line != null) {
            res_text += (line + "\n");
            chars += line.length();
            line = in.readLine();
        }
        in.close();




        BufferedWriter out = new BufferedWriter(new FileWriter(file_4.getParent() + "/" + file_4.getName()));
        out.write(res_text);
        out.close();


        return chars;
    }

    public void f7(ArrayList<String> words, String to) throws IOException {
        Map<String, Integer> www = new HashMap<String, Integer>();

        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();
        String res_text = "";
        while(line != null) {
            res_text += (line + "\n");
            line = in.readLine();
        }
        in.close();

        for (String word : words) {

            final int[] count = {0};//Компилятор сам исправил.

            String[] strs = res_text.split(" ");
            Arrays.stream(strs).forEach((str)->{
                if (str == word){
                    count[0]++;
                }
            });

            www.put(word, count[0]);

            res_text = res_text.replace(word, to);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter(file.getParent() + "/" +  file.getName()));
        out.write(res_text);
        out.close();
    }




    public void Just() throws IOException {
        System.out.println("File name: " + file.getName());
        System.out.println("Parent folder: " + file.getParent());

        BufferedReader in = new BufferedReader(new FileReader(file.getParent() + "/" +  file.getName()));
        String line = in.readLine();
        while(line != null) {
            System.out.println(line);
            line = in.readLine();
        }
        in.close();
    }
}
