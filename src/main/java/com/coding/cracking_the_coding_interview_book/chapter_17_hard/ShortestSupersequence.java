package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
import java.util.HashSet;

public class ShortestSupersequence {
    public static int[] findShortestSeq(int[] smallerArr, int[] biggerArr){
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[]{-1,-1};
        for(int left=0; left<biggerArr.length; left++){
            for(int right=left; right<biggerArr.length; right++){
                int length = right-left+1;
                if(containsAll(smallerArr, biggerArr, left, right)){
                    if(length<minLength){
                        minLength=length;
                        result[0]=left;
                        result[1]=right;
                    }
                }
            }
        }
        return result;
    }
    public static boolean containsAll(int[] s, int[] b,int left, int right){
        HashSet<Integer> set = new HashSet<>();
        for(int i=left; i<right; i++){
            set.add(b[i]);
        }
        for(int t: s){
            if(!set.contains(t)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] smallerArr = {1, 5, 9};
        int[] biggerArr = {7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 5, 9, 2, 3};
        System.out.println(Arrays.toString(findShortestSeq(smallerArr, biggerArr)));
    }
}
