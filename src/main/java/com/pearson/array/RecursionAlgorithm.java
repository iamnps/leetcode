package com.pearson.array;
/**
 * 递归练习
 */
public class RecursionAlgorithm {

    public static void main(String[] args) {
        recursionAlgorithm(1000);
    }
    
    //递归反向打印数字
    private static void recursionAlgorithm(int x){
        if(x >= 10){
            recursionAlgorithm(x / 10);
        }
        System.out.println(x - (x / 10) * 10);
    }
}
