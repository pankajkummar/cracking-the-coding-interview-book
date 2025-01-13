package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestK {
    public static int[] findSmallestK(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[k];
        for(int e: arr){
            queue.add(e);
        }
        for(int i=0 ; i<k; i++){
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k=3;
        System.out.println(Arrays.toString(findSmallestK(arr,k)));
    }
}
