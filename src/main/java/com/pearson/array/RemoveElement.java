package com.nps.tacocloud.controller.design;

import java.util.Arrays;

/**
 * leetcode 27
 * Created by peishen.nie on 2021/7/20.
 */
public class RemoveElement {

    private  static int[] nums = {0,1,2,2,3,0,4,2};

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 0));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int x = nums.length - 1, i = 0;
        while (i <= x){
            if(nums[i] != val){
                i++;
                continue;
            }
            if(nums[x] != val){
                nums[i] = nums[x];
            }
            x--;
        }
        x++;
        return x;
    }
}
