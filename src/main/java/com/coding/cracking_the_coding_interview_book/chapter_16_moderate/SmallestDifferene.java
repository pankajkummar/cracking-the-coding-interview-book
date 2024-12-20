package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.Arrays;

public class SmallestDifferene {
    public static int[] difference(int[] arrA, int[] arrB){
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int[] ans = new int[2];
        int pointer1=0;
        int pointer2=0;
        int diff= Integer.MAX_VALUE;
        while(pointer1<arrA.length && pointer2<arrB.length){
            if(Math.abs(arrA[pointer1]-arrB[pointer2])<diff){
                diff=Math.abs(arrA[pointer1]-arrB[pointer2]);
                ans[0]=arrA[pointer1];
                ans[1]=arrB[pointer2];
            }
            if(arrA[pointer1]<arrB[pointer2]){
                pointer1++;
            }
            else{
                pointer2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a={1,3,15,11,2};
        int[] b={23,127,235,19,8};
        int[] ans = difference(a,b);
        System.out.println("{"+ans[0]+","+ans[1]+"}");
    }
}
