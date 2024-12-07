package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

public class CoinChange {
    public static int countWays(int[] coins, int n, int index){
        if(n==0){
            return 1;
        }
        if(n<0 || index >= coins.length){
            return 0;
        }
        int include = countWays(coins,n-coins[index],index);
        int exclude = countWays(coins,n,index+1);
        return include+exclude;
    }

    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int n=75
                ;
        System.out.println(countWays(coins,n,0));
    }
}
