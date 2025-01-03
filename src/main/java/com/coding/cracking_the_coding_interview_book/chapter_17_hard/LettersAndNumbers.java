package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;

public class LettersAndNumbers {
    public static char[] subArray(char[] arr){
        int startIndex=0;
        int subArrayIndex=0;
        int subArrayLength=0;
        for(int i=0; i<arr.length; i++){
            startIndex=i;
            int length=0;
            int sum=0;
            for(int j=startIndex; j<arr.length; j++){
                length++;
                if(Character.isDigit(arr[j])){
                    sum = sum+1;

                }else{
                    sum=sum-1;
                }
                if(length>subArrayLength && sum==0){
                    subArrayIndex=startIndex;
                    subArrayLength=length;

                }

            }
        }
        return Arrays.copyOfRange(arr,subArrayIndex,subArrayIndex+subArrayLength);
    }

    public static void main(String[] args) {
        char[] arr= {'a', 'b', '1', '2', 'c', 'd', '3'};
        System.out.println(Arrays.toString(subArray(arr)));
    }
}
