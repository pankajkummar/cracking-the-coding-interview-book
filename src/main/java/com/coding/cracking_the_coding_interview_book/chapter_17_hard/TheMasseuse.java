package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;

public class TheMasseuse {
    public static int findMaxEarning(int[] appointments){
        int[] memo = new int[appointments.length];
        Arrays.fill(memo,-1);
        return maxEarning(0,appointments,memo);

    }
    public static int maxEarning(int k, int[] appointments,int[] memo){
        if(k>=appointments.length){
            return 0;
        }
        if(memo[k]!=-1){
            return memo[k];
        }
        int skip = maxEarning(k+1,appointments,memo);
        int take = appointments[k]+maxEarning(k+2,appointments,memo);
        memo[k] = Math.max(take,skip);
        return memo[k];
    }

    public static void main(String[] args) {
        int[] appointments = {30,15,60,75,45,15,15,45};
        System.out.println(findMaxEarning(appointments));
    }
}
