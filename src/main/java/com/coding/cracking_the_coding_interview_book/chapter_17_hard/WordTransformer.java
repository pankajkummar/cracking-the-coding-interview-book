package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.*;

public class WordTransformer {
    public static List<String> transform(String[] words, String input, String output){
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        Map<String,String> previous = new HashMap<>();
        stack.push(input);
        previous.put(input, null);
        visited.add(input);
        while(!stack.isEmpty()){
            String current = stack.pop();
            if(Objects.equals(current, output)){
                break;
            }
            for(int i=0; i<words.length; i++){

                    if(isOneWordAway(current, words[i]) && !visited.contains(words[i]))
                    {
                        stack.add(words[i]);
                        previous.put(words[i],current);
                        visited.add(words[i]);
                    }

            }

        }

        return constructPath(previous,input,output);
    }

    private static List<String> constructPath(Map<String, String> previous, String input, String output) {
        LinkedList<String> path = new LinkedList<>();
        String current = output;
        while(current!=null){
            path.addFirst(current);
            current = previous.get(current);
        }
        return path;
    }

    public static boolean isOneWordAway(String word1 , String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        if(word1 == word2){
            return false;
        }
        int diff =0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                diff++;
            }
            if(diff>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "bat", "bet", "bot", "bog", "dog"};
        String input = "cat";
        String output = "dog";

        List<String> transformation = transform(words, input, output);
        System.out.println("Tranform path : " + transformation);
    }
}
