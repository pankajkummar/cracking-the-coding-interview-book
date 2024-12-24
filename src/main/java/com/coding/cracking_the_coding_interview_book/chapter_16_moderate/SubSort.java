package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Arrays;

public class SubSort {
    public static int[] findSubSor(int[]arr){
        int left=0;
        int m=-1,n=-1,i=0;
        int right=arr.length-1;
        while(i<arr.length){
            i++;
            int[] maxMin = minMaxSubarray(arr,left,right);
            if(arr[left]<=maxMin[0]){
                left++;
            }
            if(arr[right]>=maxMin[1]){
                right--;
            }

        }
        return new int[]{left,right};
    }
    public static int[] minMaxSubarray(int[]arr,int i,int j){
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int k=i; k<=j; k++){
            if(arr[k]<min){
                min=arr[k];
            }
            if(arr[k]>max){
                max=arr[k];
            }
        }
        return new int[]{min,max};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        System.out.println(Arrays.toString(findSubSor(arr)));
    }
}
