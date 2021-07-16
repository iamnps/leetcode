package com.pearson.array;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower"}));
    }
    
    public static String longestCommonPrefix(String[] strs) {
        int i = 0, j = 0;
        String s = "";
        String str0 = strs[0];
        while(i < strs.length){
            if(strs[i].startsWith(str0.substring(0, 0))){
                i++;
                if(i == strs.length){
                    s = str0.substring(0, j);
                    i = 0;
                    if(j == str0.length()){
                        return s;
                    }
                    j++;
                }
            } else {
                return s;
            }
        }
        return s;
    }
}
