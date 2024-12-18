package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.Arrays;

public class GroupAnagramsUsingComparator {
    public static void sortAnagrams(String[] strs){
        Arrays.sort(strs,(a,b) ->{
            char[] charsA = a.toCharArray();
            char[] charsB = b.toCharArray();

            Arrays.sort(charsA);
            Arrays.sort(charsB);

            String sortedA = new String(charsA);
            String sortedB = new String(charsB);
            return sortedA.compareTo(sortedB);
        });
    }

    public static void main(String[] args) {
        String[] input = {"eat", "bat", "tan", "ate", "nat", "tea"};
        sortAnagrams(input);
        System.out.println(Arrays.toString(input));
    }
}
