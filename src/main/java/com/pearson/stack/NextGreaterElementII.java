package com.pearson.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * leetcode 503 Created by peishen.nie on 2021/7/22.
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII elementII = new NextGreaterElementII();
        elementII.nextGreaterElementII();
    }

    private void nextGreaterElementII() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 5, 4, 3, 2, 1 })));
    }

    // hashmap还是慢
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1;
            while (true) {
                if (x == nums.length) {
                    x = 0;
                }
                if (nums[i] < hashMap.get(x)) {
                    res[i] = hashMap.get(x);
                    break;
                }
                if (x == i) {
                    res[i] = -1;
                    break;
                }
                x++;
            }
        }
        return res;
    }

    // 太慢了
    // public int[] nextGreaterElements(int[] nums) {
    // int[] res = new int[nums.length];
    // Deque<Integer> deque = new ArrayDeque<>();
    // for (int i = 0; i < nums.length; i++) {
    // deque.add(i);
    // }
    // Deque<Integer> stack = new ArrayDeque<>();
    // for (int i = 0; i < nums.length; i++) {
    // stack.clear();
    // stack.addAll(deque);
    // boolean flag = false;
    // while (!stack.isEmpty()) {
    // if (i == stack.peek()) {
    // if (flag) {
    // res[i] = -1;
    // break;
    // }
    // stack.addLast(stack.pop());
    // flag = true;
    // }
    // if (flag && nums[stack.peek()] > nums[i]) {
    // res[i] = nums[stack.peek()];
    // break;
    // }
    // stack.addLast(stack.pop());
    // }
    // }
    // return res;
    // }

}
