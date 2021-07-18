package com.pearson.array;

import java.util.HashMap;

//leetcode 560
public class SubarraySumEqualsK {
     
    public static void main(String[] args) {
        System.out.println(subarraySumEqualsK(new int[]{1,-1,0}, 0));
    }

    //图灵视频的demo
    private static int subarraySumEqualsK(int[] nums, int k){
        int sum = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i : nums){
            sum += i;
            if(map.containsKey(sum - k)){
                j += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);  
        }
        return j;
    }
}