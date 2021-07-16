package com.pearson.integer;

public class ReverseInteger {
    
    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
    }

    //此处主要是利用取余计算方法，一步步取到个位数的值
    public static int reverseInteger(int x){
        //long型是担心边界值，可能存在int型数据反转后超出int存储范围的情况
        long a = (long) x;
        long r = 0L;
        while(a != 0){
            r = r*10 + a%10;
            a/=10;
        }
        //如果结果超出int范围，则直接false
        if(r > Integer.MAX_VALUE || r < Integer.MIN_VALUE){
            return 0;
        }
        
        return (int) r;
    }
}
