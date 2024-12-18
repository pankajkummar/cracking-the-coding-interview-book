package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

public class RotatedArraySearch {
    public static int rotatedArraySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[left]<=arr[mid]){
                if(target<arr[mid] && target>=arr[left]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target>arr[mid] && target <= arr[right]){
                    left = mid +1;
                }else{
                    right = mid -1;
                }

            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(rotatedArraySearch(nums,target));
    }
}
