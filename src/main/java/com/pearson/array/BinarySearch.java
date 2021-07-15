package com.pearson.array;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 8, 9};

        System.out.println(binarySearch1(arr, 9));
        
    }

    //查找数字k 在arr中的位置，最简单基础二分法
    public static int binarySearch1(int[] arr, int k){
        int i = 0, r = arr.length - 1;
        while(i <= r){
            int mid = i + (r - i) / 2;
            if(arr[mid] == k){
                return mid;
            } else if(arr[mid] > k){
                r = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //未找到
        return -1;
    }
    
}


    