package com.coding.cracking_the_coding_interview_book.chapter_17_hard;
import com.coding.cracking_the_coding_interview_book.chapter_17_hard.UnionFind.UnionFind;
import java.util.HashMap;


public class BabyNames {

    public static HashMap<String,Integer> nameFrequency(HashMap<String,Integer> frequency, String[][] synonymNames){

        UnionFind<String> unionFind = new UnionFind<>();
        HashMap<String,Integer> mergedFrequency = new HashMap<>();
        for(String name: frequency.keySet()){
            unionFind.add(name);
        }
        for(String[] pair: synonymNames){
            unionFind.union(pair[0],pair[1]);
        }
        for(String name: frequency.keySet()){
            String root = unionFind.find(name);
            mergedFrequency.put(root, frequency.get(name)+mergedFrequency.getOrDefault(root,0));
        }

        return mergedFrequency;
    }

    public static void main(String[] args) {
        HashMap<String,Integer> frequency = new HashMap<>();
        frequency.put("john", 15);
        frequency.put("jon", 12);
        frequency.put("chris", 13);
        frequency.put("kris", 4);
        frequency.put("johnny", 0);
        frequency.put("christopher", 19);
        String[][] synonymNames = {{"jon","john"},{"john","johnny"},{"chris","kris"},{"chris","christopher"}};
        nameFrequency(frequency, synonymNames).forEach((key,value) -> System.out.println(key + " => "+ value));

    }


}
