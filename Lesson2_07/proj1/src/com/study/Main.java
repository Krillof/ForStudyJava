package com.study;

public class Main {

    public static void main(String[] args) {

        for (Operation op : Operation.values()){
            System.out.println(op.action(10, 20));
        }

        for (MyBool b : MyBool.values()){
            if (b.equals(MyBool.True)){
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}


enum Operation {
    SUM{public int action(int x, int y){
        return x + y;
    }},
    MULT{
        public int action(int x, int y){
            return x * y;
        }
    };

    abstract int action(int x, int y);
}

enum MyBool {
    True,
    False
}