package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int minIndex=i;
            int min=arr[i];
            for(int j=i; j<arr.length; j++){
                if(arr[j]<min){
                    min = arr[j];
                    minIndex=j;
                }
            }
            int temp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,2,1,9,7,8,6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
