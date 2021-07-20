package com.pearson.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode 80
 * Created by peishen.nie on 2021/7/20.
 */
public class RemoveDuplicatesfromSortedArrayII {

    private static int[] nums = {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,5,5,5};//

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII arrayII = new RemoveDuplicatesfromSortedArrayII();
        System.out.println(arrayII.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, r = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (i < r){
            int x = map.getOrDefault(nums[i], 0);
            map.put(nums[i], x+1);
            if(map.get(nums[i]) > 2){
                int temp = nums[i];
                if(map.getOrDefault(nums[r-1], 0) >= 2){
                    r--;
                    continue;
                }
                nums[i] = nums[r-1];
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
                nums[r-1] = temp;
                r--;
            }
            i++;
        }
        Arrays.sort(nums,0, r);
        return r;
    }
}
