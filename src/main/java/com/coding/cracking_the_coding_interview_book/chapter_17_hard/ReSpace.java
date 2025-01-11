package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.HashSet;
import java.util.Set;

public class ReSpace {
    public static String reSpace(String str, String[] dictionary){
        Set<String> wordSet = new HashSet<>();
        for(String word: dictionary){
            wordSet.add(word);
        }
        String[] reconstruction = new String[str.length()+1];
        int[] dp = new int[str.length() + 1];
        for(int i=1; i<=str.length(); i++){
            dp[i] = dp[i-1]+1;
            reconstruction[i]=null;
            for(int j=0; j<i; j++){
                String substring = str.substring(j,i);
                if(wordSet.contains(substring)){
                    if(dp[j]<dp[i]) {
                        dp[i] = dp[j];
                        reconstruction[i] = substring;
                    }
                }
            }
        }
        StringBuilder spacedSentence = new StringBuilder();
        int i = str.length();
        while(i>0){
            String part = reconstruction[i];
            if(part==null){
                part = str.substring(i-1,i);
            }
            spacedSentence.insert(0, part+" ");
            i-=part.length();
        }
        return spacedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String[] dictionary = { "look", "like", "sam", "sung", "just", "brother" };
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(reSpace(sentence,dictionary));
    }
}
