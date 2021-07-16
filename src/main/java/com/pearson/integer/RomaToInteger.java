package com.pearson.integer;

public class RomaToInteger {

    public static void main(String[] args) {
        System.out.println(romaToInteger("IX"));
    }

    //以i作为基准，j作为上一个数字的值，罗马字标准中，从右往左：当右比大则‘右-左‘；右比左小则’右+左‘
    private static int romaToInteger(String s){
        int i  = s.length(), j = 0, r = 0;
        while(i > 0){
            int a = getInt(s.substring(i-1, i));
            if(a < j){
                r = r - a;
            } else {
                r += a;
            }
            i-=1;
            j = a;
        }
        
        return r;
    }

    //根据罗马字获取数字
    private static int getInt(String string){
        switch(string){
            case "I": return 1; 
            case "V": return 5; 
            case "X": return 10; 
            case "L": return 50; 
            case "C": return 100; 
            case "D": return 500; 
            case "M": return 1000;
        }

        return 0;
    }
}
