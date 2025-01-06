package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BabyNames {
    public static class Pair<T,U>{
        public T first;
        public U second;

        public Pair(T first, U second){
            this.first = first;
            this.second = second;
        }
    }
    public static HashMap<String,Integer> nameFrequency(HashMap<String,Integer> frequency, List<Pair<String,String>> synonymNames){
        HashMap<String, Set<String>> names = mergeNames(synonymNames);
        return new HashMap<>();
    }

    private static HashMap<String, Set<String>> mergeNames(List<Pair<String, String>> synonymNames) {
        HashMap<String,Set<String>> names = new HashMap<>();
        for(Pair pair: synonymNames){
            if(names.)
        }
    }
}
