package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strArray){
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String str:strArray){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = Arrays.toString(ch);
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(str);
            }else{
                map.put(sortedStr,new ArrayList<>());
                map.get(sortedStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        ArrayList<ArrayList<String>> groupedAnagrams = groupAnagrams(strs);
        System.out.println(groupedAnagrams);
    }
}
