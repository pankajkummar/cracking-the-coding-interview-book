package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class circusTower {
    public static int towerLength(int[][] people){
        Arrays.sort(people, Comparator.comparingInt((int[] p) -> p[0]).thenComparingInt(p -> p[1]));
        int[] dp = new int[people.length];
        Arrays.fill(dp, 1);
        int maxHeight=1;
        for(int i=1; i<people.length; i++){
            for(int j=0; j<i; j++){
                if(people[i][1]>people[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxHeight=Math.max(maxHeight, dp[i]);

        }

        return maxHeight;
    }

    public static void main(String[] args) {
        int[][] people = {{65,100},{70,150},{56,90},{67,80},{75,190},{60,95},{68,110}};
        System.out.println(towerLength(people));
    }
}
