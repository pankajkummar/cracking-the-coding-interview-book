package com.coding.cracking_the_coding_interview_book.chapter_17_hard;
// water trapped at i = max(0,min(MaxLeft[i],maxRight[i])-height[i])
public class VolumeOfHistogram {
    public static int volume(int[] arr){
        int water =0;
        for(int i=0; i<arr.length; i++){
            int water_i = Math.max(0,Math.min(findMax(arr, 0, i),findMax(arr, i, arr.length-1))-arr[i]);
            water = water + water_i;
        }
        return water;
    }
    public static int findMax(int[] arr, int left, int right){
        int max = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};
        System.out.println(volume(arr));
    }
}
