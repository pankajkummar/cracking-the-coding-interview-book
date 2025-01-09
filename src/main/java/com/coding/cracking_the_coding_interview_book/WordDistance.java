package com.coding.cracking_the_coding_interview_book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {
    public static HashMap<String, List<Integer>> createMap(String[] file){
        HashMap<String, List<Integer>> map = new HashMap<>();
        for( int i=0; i<file.length; i++){
            map.putIfAbsent(file[i],map.getOrDefault(file[i], new ArrayList<>()));
            map.get(file[i]).add(i);
        }
        return map;
    }
    public static int findDistance(HashMap<String,List<Integer>> map,  String word1, String word2){
        List<Integer> word1Index = map.get(word1);
        List<Integer> word2Index = map.get(word2);
        int distance = Integer.MAX_VALUE;
        for(int i: word1Index){
            for(int j: word2Index){
                if(Math.abs(i-j)<distance){
                    distance = Math.abs(i-j);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] file = {
                "apple", "banana", "cherry", "apple", "banana",
                "date", "elderberry", "fig", "grape", "honeydew",
                "kiwi", "lime", "mango", "banana", "apple",
                "nectarine", "orange", "papaya", "cherry", "grape"
        };
        HashMap<String,List<Integer>> map = createMap(file);
        map.forEach((key,value) -> System.out.println(key + " => " + value));
        System.out.println("Distance :"+findDistance(map,"banana","papaya"));

    }

}
