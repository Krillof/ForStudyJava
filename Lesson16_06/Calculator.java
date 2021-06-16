package com.study.Lesson16_06;

import java.util.ArrayList;

public class Calculator {

    public ArrayList<Integer> arr = new ArrayList<>();
    public int a = 0;

    public Calculator(int a, ArrayList<Integer> arr){
        this.a = a;
        this.arr = arr;
    }

    public float getSumOfFractions(float x, float y){
        return x+y;
    }

    public float getMinusOfFractions(float x, float y){
        return x-y;
    }

    public float getMultiplyOfFractions(float x, float y){
        return x*y;
    }

    public float getDivisionOfFractions(float x, float y) throws Exception{
        return x/y;
    }




    public int getSum(int x, int y){
        return x+y;
    }

    public int getMinus(int x, int y){
        return x-y;
    }

    public int getMultiply(int x, int y){
        return x*y;
    }

    public int getDivision(int x, int y){
        return x/y;
    }

    public int getMax(int x, int y){
        return Math.max(x, y);
    }

    public int getMin(int x, int y){
        return Math.min(x, y);
    }

    public int getPercentOf(int x, int percent){
        return x*percent/100;
    }

    public float getDegreeOfNumber(float x, int y){
        float a = x;
        if (y>0) for (int f = 1; f < y; f++) a*=x;
        else if (y==0) a= 1;
        else {
            a = 1/a;
            for (int f = -1; f > y; f--) a/=x;
        }
        return a;
    }

    public int getArrSum(){
        int s = 0;
        for (int f = 0; f < arr.size(); f++){
            s+=arr.get(f);
        }
        return s;
    }

    public int getArrAverage(){
        int s = 0;
        for (int f = 0; f < arr.size(); f++){
            s+=arr.get(f);
        }
        return s/arr.size();
    }

    public int getArrMax(){
        int max = Integer.MIN_VALUE;
        for (int f=  0; f < arr.size(); f++){
            if (max < arr.get(f)) max = arr.get(f);
        }
        return max;
    }

    public int getArrMin(){
        int min = Integer.MAX_VALUE;
        for (int f=  0; f < arr.size(); f++){
            if (min > arr.get(f)) min = arr.get(f);
        }
        return min;
    }

    public void setNumber(int a){
        this.a = a;
    }

    public int getNumber(){
        return a;
    }

    public String getNumberInEight(){
        return Integer.toOctalString(a);
    }

    public String getNumberInBinary(){
        return Integer.toBinaryString(a);
    }

    public String getNumberInHex(){
        return Integer.toHexString(a);
    }

}
