package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.Arrays;

public class SortedMerge {
    public static void sortedMerge(int[] arrA, int[] arrB,int sizeA){
        int i=sizeA-1,j=arrB.length-1,k=arrA.length-1;
        while( i>=0 && j>=0){
            if(arrA[i]>arrB[j]){
                arrA[k--]=arrA[i--];
            }else{
                arrA[k--]=arrB[j--];
            }

        }
        while(j>=0){
            arrA[k--]=arrB[j--];
        }
    }

    public static void main(String[] args) {
        int[] arrA={1,3,5,7,9,11,0,0,0,0,0};
        int[] arrB={2,4,6,8,10};
        sortedMerge(arrA,arrB,6);
        System.out.println(Arrays.toString(arrA));;
    }
}
