package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
import java.util.HashMap;

public class LettersAndNumbers {
    public static char[] subArray(char[] arr){
        int subArrayIndex=0;
        int subArrayLength=0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<arr.length; i++){
            if(Character.isDigit(arr[i])){
                sum = sum+1;

            }else{
                sum=sum-1;
            }
            if(map.containsKey(sum)){
                int indexSum = map.get(sum);
                if(subArrayLength<(i-indexSum)){
                    subArrayLength=i-indexSum;
                    subArrayIndex=indexSum+1;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        return Arrays.copyOfRange(arr,subArrayIndex,subArrayIndex+subArrayLength);
    }

    public static void main(String[] args) {
        char[] arr= {'4','a', '1', '2', 'c', 'd', '3'};
        System.out.println(Arrays.toString(subArray(arr)));
    }
}
