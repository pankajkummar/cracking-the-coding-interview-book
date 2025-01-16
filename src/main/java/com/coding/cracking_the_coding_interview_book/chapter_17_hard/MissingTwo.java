package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;

public class MissingTwo {
    public static int[] findMissing(int[] arr){
        int[] result = {-1,-1};
        int i=0;
        int missOffset=0;
         while(i<arr.length)
         {
            if(i+missOffset!=arr[i]){
                if(result[0]==-1){
                    result[0]=i;
                    missOffset++;
                }else {
                    result[1] = i+missOffset;
                    break;
                }
            }else{
                i++;
            }
           
        }
         if(result[0]==-1){
             result[0]=arr[arr.length-1]+1;
             result[1]=arr[arr.length-1]+2;
         }
        if(result[1]==-1){
            result[1]=arr[arr.length-1]+1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,5,6,7,8,10};
        System.out.println(Arrays.toString(findMissing(arr)));
    }
}
