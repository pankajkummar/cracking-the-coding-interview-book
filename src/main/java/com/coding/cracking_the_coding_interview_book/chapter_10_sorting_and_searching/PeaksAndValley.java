package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.Arrays;

public class PeaksAndValley {
    public static void formPeakValley(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(i%2==0){
                if(arr[i+1]>arr[i]){
                    swap(arr,i+1,i);
                }
            }
            else{
                if(arr[i+1]<arr[i]){
                    swap(arr,i+1,i);
                }
            }
        }
    }
    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,2,3,3};
        formPeakValley(arr);
        System.out.println(Arrays.toString(arr));
    }
}
