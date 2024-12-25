package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Arrays;

public class ContiguousSequence {
    public static int[] findLargestSum(int[] arr){
        int maxEndinghere = arr[0];
        int maxSoFar = arr[0];
        int start=0, end=0, tempStart=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>maxEndinghere+arr[i]){
                maxEndinghere=arr[i];
                tempStart = i;
            }
            else{
                maxEndinghere += arr[i];
            }
            if(maxEndinghere>maxSoFar){
                maxSoFar = maxEndinghere;
                start = tempStart;
                end = i;
            }

        }
        int[] result = Arrays.copyOfRange(arr,start,end+1);
        return new int[]{maxSoFar,start,end,result.length};
    }

    public static void main(String[] args) {
        int[] arr = {2,-8,3,-2,4,-10};
        int[] result = findLargestSum(arr);
        System.out.println("largest sum "+result[0]);
        System.out.println("Subarray indicies: start = "+result[1]+" , end = " + result[2]);
    }
}
