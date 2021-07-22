package com.pearson.stack;

import java.util.*;

/**
 * leetcode 496
 * Created by peishen.nie on 2021/7/22.
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI elementI = new NextGreaterElementI();
        elementI.nextGreaterElementI();
    }

    private void nextGreaterElementI(){
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2,3}, new int[]{3,1,2})));
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            hashMap.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int x = hashMap.get(nums1[i]); x < nums2.length; x++){
                if(nums2[x] > nums1[i]){
                    arr[i] = nums2[x];
                    break;
                }
            }
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        return arr;
    }

    /*双重for循环很慢
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int x : nums2){
                if(x == nums1[i]){
                    flag = true;
                }
                if(flag && nums1[i] < x){
                    arr[i] = x;
                    break;
                }
            }
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        return arr;
    }*/
}
