package com.pearson.array;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.cglib.core.HashCodeCustomizer;

public class TwoSum {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,3}, 4)));
    }

    //取出数组中，两个元素相加是目标数的下标
    private static int[] twoSum(int nums[], int target){
            HashMap<Integer, Integer> map = new HashMap<>();
            int i = 0;
            while(i <= nums.length - 1){
                if(map.containsKey(target - nums[i])){
                    return new int[]{map.get(target - nums[i]), i};
                }   
                map.put(nums[i], i);  
                i++;
            }
            return nums;
    }
}
