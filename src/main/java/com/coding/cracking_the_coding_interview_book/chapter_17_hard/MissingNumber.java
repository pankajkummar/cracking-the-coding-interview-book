package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

public class MissingNumber {
    public static int findMissing(int[] arr){
        int n = arr.length;
        int expectedSum = (n)*(n+1)/2;  // array is starting from 0
        int actualSum=0;
        for(int t :arr){
            actualSum = actualSum+t;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,6,7};
        System.out.println(findMissing(arr));
    }
}
