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
        dp[0] = 0;
        reconstruction[0] = "";
        for(int i=1; i<=str.length(); i++){
            dp[i] = dp[i-1]+1;
            reconstruction[i]=reconstruction[i - 1] + str.charAt(i - 1);
            for(int j=0; j<i; j++){
                String substring = str.substring(j,i);
                if(wordSet.contains(substring)){
                    if(dp[j]<dp[i]) {
                        dp[i] = dp[j];
                        reconstruction[i] = reconstruction[j] + " " + substring;
                    }
                }
            }
        }

        return reconstruction[str.length()].trim();
    }

    public static void main(String[] args) {
        String[] dictionary = { "look", "like", "sam", "sung", "just", "brother" };
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(reSpace(sentence,dictionary));
    }
}
