package com.pearson.array;

public class RemoveDuplicate {
     
    public static void main(String[] args) {
        int[] sortArr = {1, 2, 2}; //sorted
        int[] notSortArr = {2, 3, 4, 3, 5, 2, 3, 6, 7}; //not sort

        System.out.println(removeDuplicateFormSortArray(sortArr)); 
        
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

}