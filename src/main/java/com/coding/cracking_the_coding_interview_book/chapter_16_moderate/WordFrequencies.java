package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.HashMap;

public class WordFrequencies {
    public static HashMap<String,Integer> setupDictionary(String[] book){
        HashMap<String,Integer> dictionary = new HashMap<>();
        for(String word:book){
            if(dictionary.containsKey(word)){
                dictionary.put(word,dictionary.get(word)+1);
            }else{
                dictionary.put(word,1);
            }
        }
        return dictionary;
    }

    public static void main(String[] args) {
        String[] book = {
                "apple", "banana", "apple", "cherry", "date",
                "apple", "elderberry", "fig", "banana", "grape",
                "honeydew", "kiwi", "lemon", "nectarine", "orange"
        };
        HashMap<String,Integer> dictionary = setupDictionary(book);
        System.out.println(dictionary.get("apple"));
        System.out.println(dictionary.get("banana"));
        System.out.println(dictionary.get("grape"));
    }
}
