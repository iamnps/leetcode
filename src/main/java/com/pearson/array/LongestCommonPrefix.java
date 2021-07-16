package com.pearson.array;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"fl3","flower","flower"}));
    }
    
    //第一个元素先提出来和后续元素做对比，对比过程中，第一个元素的第一个字符如果全部match则加一个字符继续对比，未match则返回
    public static String longestCommonPrefix(String[] strs) {
        int i = 0, j = 0;
        String str0 = strs[0];
        while(i < strs.length){
            if(!strs[i].startsWith(str0.substring(0, j))){
                break;
            }
            i++;
            if(i == strs.length){
                i = 0;
                if(j == str0.length()){
                    return str0.substring(0, j);
                }
                j++;
            }
        }
        return str0.substring(0, (j == 0 ? 0 : (j - 1)));
    }
}
