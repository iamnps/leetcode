package com.pearson.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * leetcode 503
 * Created by peishen.nie on 2021/7/22.
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII elementII = new NextGreaterElementII();
        elementII.nextGreaterElementII();
    }

    private void nextGreaterElementII(){
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,23,5,6,8})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
            deque.add(i);
        }
        for (int i = 0; i < nums.length; i++){
            while (!deque.isEmpty()){
                if(i != deque.peek()){
                    int x = deque.poll();
                    deque.addLast(x);
                }

            }

        }

        return res;
    }

}
