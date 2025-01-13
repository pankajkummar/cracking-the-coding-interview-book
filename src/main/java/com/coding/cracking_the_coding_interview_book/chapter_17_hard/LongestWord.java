package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestWord {
    public static String findLongestWord(String[] str){
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b)-> Integer.compare(b.length(), a.length()));
        maxHeap.addAll(Arrays.asList(str));
        while(!maxHeap.isEmpty()){
            String result = maxHeap.poll();
            if(isCombination(str, result)){
                return result;
            }
        }
        return null;
    }
    public static boolean isCombination(String[] str,String s){
        for (String string : str) {
            for (String value : str) {
                String combination = string + value;
                if (s.equals(combination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"cat","banana","dog","nana","walk","walker","dogwalker"};
        System.out.println(findLongestWord(arr));
    }

}
