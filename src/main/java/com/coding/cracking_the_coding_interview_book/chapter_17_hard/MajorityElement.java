package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.HashMap;

public class MajorityElement {
    public static int findMajorityElement(int[] arr){
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            count.put(arr[i],count.getOrDefault(arr[i],0)+1);
            if(count.getOrDefault(arr[i],0)>arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,9,5,9,5,5,5,4,6,7};
        System.out.println(findMajorityElement(arr));
    }
}
