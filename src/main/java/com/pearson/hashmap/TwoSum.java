package com.pearson.hashmap;

import java.util.Arrays;
import java.util.HashMap;

//leetcode 1 hashmap解法
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] { 1, 3 }, 4)));
    }

    // 取出数组中，两个元素相加是目标数的下标，hashmap解法，因为hashmap找元素的速度更快
    private static int[] twoSum(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i <= nums.length - 1) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            // 这里必须先有上面的判断，再put，防止出现a+a=b的情况
            map.put(nums[i], i);
            i++;
        }
        return nums;
    }
}
