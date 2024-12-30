package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Arrays;

public class SumSwap {
    public static int[] findSwap(int[] arr1, int[] arr2){
        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();
        for(int one: arr1){
            for(int two: arr2){
                if(sum1-one+two==sum2-two+one){
                    return new int[]{one,two};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1={4,1,2,1,1,2};
        int[] arr2={3,6,3,3};
        System.out.println(Arrays.toString(findSwap(arr1,arr2)));

    }
}
