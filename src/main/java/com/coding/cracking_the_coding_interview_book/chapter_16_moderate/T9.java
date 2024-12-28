package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T9 {
    private static final String[] T9_MAPPING = {
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> getWords(int number, String[] dictionary){
        HashMap<Integer, List<String>> map = new HashMap<>();
        for(String word: dictionary){
            int num = getNumber(word);
            List<String> wordList= map.getOrDefault(num,new ArrayList<>());
            wordList.add(word);
            map.put(num,wordList);
        }
        return map.get(number);

    }
    private static int getNumber(String word){
        int num=0;
        for(char c: word.toCharArray()){
            for(int i=0; i<T9_MAPPING.length; i++){
                if(T9_MAPPING[i].contains(String.valueOf(c))){
                    num=num*10+i;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[] dictionary= {"tree", "used", "true", "turn", "user"};
        int number=8733;
        System.out.println(getWords(number,dictionary));
    }
}
