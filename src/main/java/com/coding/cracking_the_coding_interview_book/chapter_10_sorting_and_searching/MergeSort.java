package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr.length < 2){
            return;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr,left,right);
    }

    public static   void merge(int[] arr, int[] left, int[] right){
         int i=0,j=0,k=0;

         while (i<left.length && j<right.length){
             if(left[i]<=right[j]){
                 arr[k]=left[i];
                 k++;
                 i++;
             }else{
                 arr[k]=right[j];
                 k++;
                 j++;
             }
         }
         while(i<left.length){
             arr[k]=left[i];
             k++;
             i++;
         }
         while(j<right.length){
             arr[k]=right[j];
             k++;
             j++;
         }
    }

    public static void main(String[] args) {
        int[] arr = {5,3,4,6,1,9,8,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

