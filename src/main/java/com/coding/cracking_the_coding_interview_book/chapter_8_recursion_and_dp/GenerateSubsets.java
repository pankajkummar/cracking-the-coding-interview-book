package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public static List<List<Integer>> getSubsets(List<Integer> set){
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(set,0,new ArrayList<>(),result);
        return result;

    }

    private static void generateSubsets(List<Integer> set, int index,List<Integer> current, List<List<Integer>> result) {
        if(set.size() == index){
            result.add(new ArrayList<>(current));
            return;
        }
        generateSubsets(set,index+1,current,result);
        current.add(set.get(index));
        generateSubsets(set,index+1,current,result);
        current.remove(current.size()-1);

    }

    public static void main(String[] args) {
        List<Integer> set = List.of(1, 2, 3);
        List<List<Integer>> subsets = getSubsets(set);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
