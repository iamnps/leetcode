package com.nps.tacocloud.controller.design;

import java.util.Arrays;

/**
 * leetcode 283
 * Created by peishen.nie on 2021/7/20.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        System.out.println(Arrays.toString(moveZeroes.moveZeroes(new int[]{0,1})));
    }

    public int[] moveZeroes(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int x = 0, i = 1;
        while (i < nums.length){
            if(nums[x] == 0 && nums[i] == 0){
                i++;
                continue;
            }
            if(nums[x] == 0) {
                nums[x] = nums[i];
                nums[i] = 0;
            }
            x++;
            i++;

        }

        return nums;
    }
}
