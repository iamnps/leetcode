package com.pearson.array;

public class ReveresString {

    public static void main(String[] args) {
        char[] charAr = {'h', 'e', 'l', 'l', 'o'};

        charAr = reveresString(charAr);
        
        for(char temp : charAr){
            System.out.println(temp);
        }
    }
    
    public static char[] reveresString(char[] charAr){
        int i = 0; 
        int j = charAr.length - 1;
        while(i < j){
            char temp = charAr[i];
            charAr[i] = charAr[j];
            charAr[j] = temp;
            i++;
            j--;
        }
        
        return charAr;
    } 

}
