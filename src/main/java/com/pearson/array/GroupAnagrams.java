package com.pearson.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagrams {
    
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"","",""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 1;
        while(i < strs.length){
            if(set.contains(i)){
                i++;
                j= i+1;
                continue;
            }
            List<String> list = new ArrayList<>();
            char[] arr = strs[i].toCharArray();
            list.add(strs[i]);
            Arrays.sort(arr);
            set.add(i);
            while(j < strs.length){
                if(set.contains(j)){
                    j++;
                    continue;
                }
                char[] arr1 = strs[j].toCharArray();
                Arrays.sort(arr1);
                if(Arrays.equals(arr, arr1)){
                    list.add(strs[j]);
                    set.add(j);
                }
                j++;
            }
            res.add(list);
            i++;
            j= i+1;
        }
        return res;
    }
}
