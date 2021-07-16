package com.pearson.integer;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(palindromeNumber(1111111119));
    }

    //先将字符串反转，再与原字符串对比
    private static boolean palindromeNumber(int x){
        if(x < 0){
            return false;
        }
        int a  = 0, c = x;
        while(c != 0){
            a = a*10 + c%10;
            c/=10;
        }
        return a == x;
    }


    //先将数字转为string，然后前后对照，速度较慢
    // private static boolean palindromeNumber(int x){
    //     String s = x+"";
    //     int i = 0, j = s.length();
    //     while(i < s.length() && i != j){
    //         if(!s.substring(i, i+1).equals(s.substring(j-1, j))){
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

}
