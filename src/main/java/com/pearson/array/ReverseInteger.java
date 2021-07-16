package com.pearson.array;

public class ReverseInteger {
    
    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
    }

    public static int reverseInteger(int x){
        long a = (long) x;
        long r = 0L;
        while(a != 0){
            r = r*10 + a%10;
            a/=10;
        }

        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            return 0;
        }
        
        return (int) r;
    }
}
