package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

import java.util.Arrays;

public class TripleStep {
    public int countWaysMemo(int n, int[] memo){
        if(n<0) return 0;
        if(n==0) return 1;
        if(memo[n]!=-1){
            return memo[n];
        }
         memo[n]=countWaysMemo(n-1,memo)+countWaysMemo(n-2,memo)+ countWaysMemo(n-3,memo);
        return memo[n];
    }
    public int countWays(int n){
        if(n<0) return 0;
        if(n==0) return 1;

        return countWays(n-1)+countWays(n-2)+ countWays(n-3);
//comment using the keyboard

    }

    public static void main(String[] args) {

        TripleStep ts = new TripleStep();
        int n=50;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        long startTime = System.currentTimeMillis();
        System.out.println("only recursion "+ts.countWays(n));
        long endTime = System.currentTimeMillis();
        System.out.println("time taken only recursion in ms : "+ (endTime-startTime));
        long startTime2 = System.currentTimeMillis();
        System.out.println("recursion with memo "+ts.countWaysMemo(n,memo));
        long endTime2 = System.currentTimeMillis();
        System.out.println("time taken recursion + memo in ms : "+ (endTime2-startTime2));
    }
}
