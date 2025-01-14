package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiSearch {
    public static HashMap<String, List<Integer>> multiSearch(String b, String[] t) {
        HashMap<String, List<Integer>> solution = new HashMap<>();

        for (String s : t) {
            List<Integer> indices = new ArrayList<>();
            int index = b.indexOf(s); // Use indexOf to find the first occurrence
            while (index != -1) {
                indices.add(index); // Add index to the list
                index = b.indexOf(s, index + 1); // Search for the next occurrence
            }
            if (!indices.isEmpty()) {
                solution.put(s, indices); // Only add strings with matches to the solution
            }
        }

        return solution;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String[] strings = {"is", "sip", "hi", "sis"};
        multiSearch(s, strings).forEach((key, value) -> System.out.println(key + " => " + value));
    }
}