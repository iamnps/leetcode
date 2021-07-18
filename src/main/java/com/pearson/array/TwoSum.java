package com.pearson.array;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.cglib.core.HashCodeCustomizer;

public class TwoSum {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,3}, 4)));
    }

    //
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = 1;
        while (i < j){
            if (target != (nums[j] + nums[i])){
                j++;
                if(j == nums.length){
                    i++;
                    j = i + 1;
                }
            } else {
                return new int[]{i, j};
            }
        }
        return nums;
    }


    
}
