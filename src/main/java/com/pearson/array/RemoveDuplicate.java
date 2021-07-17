package com.pearson.array;

import java.util.Arrays;

public class RemoveDuplicate {
     
    public static void main(String[] args) {
        int[] sortArr = {1, 2, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8, 10}; //sorted
        int[] notSortArr = {2, 3, 4, 3, 5, 2, 3, 6, 7}; //not sort

        // System.out.println(removeDuplicateFormSortArray(sortArr)); 
        System.out.println(Arrays.toString(getIntArray(sortArr, 5)));
    }

    //在数组合理的情况下，取出相连的数
    private static int[] getIntArray(int[] arr, int x){
        int i = 0, j = 0;
        int[] temp = new int[x];
        while(i < arr.length - 1){
            if(arr[i] + 1 == arr[i+1]){
                temp[j] = arr[i];
                j++;
                if(j == x-1){
                    temp[j] = arr[i+1];
                    break;
                }
            } else {
                j = 0;
                temp = new int[x];
            }
            i++;
        }

        return temp;
    } 


    private static int removeDuplicateFormSortArray(int[] sortArr){
        int i = 0, j = 0;
        while(j < sortArr.length){
            if(i == 0 || sortArr[i - 1] != sortArr[j]){
                sortArr[i++] = sortArr[j++];
            } else{
                j++;
            }
        }
        return i;
    }

    private static int removeDuplicateFormNotSortArray(int[] notSortArr){
        
        return 1;
    }

}