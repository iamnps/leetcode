package com.pearson.array;

/**
 * leetcode 11
 * Created by peishen.nie on 2021/7/19.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater water = new ContainerWithMostWater();
        water.containerWithMostWater();;
    }

    public void containerWithMostWater(){
        System.out.println(maxArea(new int[]{1,2,4,3}));
    }

    //双指针一起向中间走，如果左边比右边大则右边走，右边比左边大则左边走，再两个数字中取叫小数相乘再乘下标距离，加一个存值的r存对大值即可
    public int maxArea(int[] height) {
        int i = 0, r = 0, x = height.length - 1;
        while (x > i){
            int a = height[i] > height[x] ? height[x] : height[i];
            r = a * (x - i) > r ? a * (x - i) : r;
            if(height[i] >= height[x]){
                x--;
            } else {
                i++;
            }
        }
        return r;
    }

    /*这种遍历次数太多，会挂掉
    public int maxArea(int[] height) {
        int i = 0, r = 0, x = 1;
        while (x < height.length){
            int a = height[i] > height[x] ? height[x] : height[i];
            r = a * (x - i) > r ? a * (x - i) : r;
            x++;
            if(x == height.length){
                i++;
                x = i + 1;
            }
            if(i == height.length){
                break;
            }
        }
        return r;
    }*/

}
