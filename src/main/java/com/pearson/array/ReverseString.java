package com.pearson.array;

public class ReverseString {

    public static void main(String[] args) {
        char[] charAr = {'h', 'e', 'l', 'l', 'o'};

        charAr = reverseString(charAr);
        //print
        for(char temp : charAr){
            System.out.println(temp);
        }
    }
    
    //两个下标数字，互相替换位置即可
    public static char[] reverseString(char[] charAr){
        //initialize
        int i = 0, j = charAr.length - 1;
        //two pointers opposite direction
        while(i < j){
            // swap charAr[i] and char[j]
            char temp = charAr[i];
            charAr[i] = charAr[j];
            charAr[j] = temp;
            i++;
            j--;
        }
        
        return charAr;
    } 

}
