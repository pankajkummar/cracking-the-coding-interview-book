package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length;i++){
            boolean swap = false;
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swap=true;  //to check if array is already sorted
                }
            }
            if(!swap){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr={2,3,5,1,4,6,8,9,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
