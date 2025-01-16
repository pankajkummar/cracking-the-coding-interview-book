package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
import java.util.HashSet;

public class shortestSubsequenceSlidingWindow {
    public static int[] findSubsequence(int[] smallArray, int[] bigArray){
        int start=0;
        int end=0;
        int[] result = {-1,-1};
        int minLength = Integer.MAX_VALUE;
        while(end<bigArray.length){
            if(!containsAll(smallArray, bigArray, start, end))
            {
                end++;
            }else{
                if(containsAll(smallArray, bigArray, start, end)){
                    int length = end-start;
                    if(length<minLength){
                        minLength=length;
                        result[0]=start;
                        result[1]=end;
                    }
                    start++;
                }
            }
        }
        return result;
    }
    public static boolean containsAll(int[] s, int[] b, int left, int right){
        HashSet<Integer> set = new HashSet<>();
        for(int i=left; i<=right; i++){
            set.add(b[i]);
        }
        for(int k: s){
            if(!set.contains(k)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] smallerArr = {1, 5, 9};
        int[] biggerArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 5, 9, 2, 3};
        System.out.println(Arrays.toString(findSubsequence(smallerArr, biggerArr)));
    }
}
