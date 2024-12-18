package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(arr[mid]==target){
                return mid;
            }if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9};
        int target = 7;
        System.out.println(binarySearch(arr,target));
    }
}
