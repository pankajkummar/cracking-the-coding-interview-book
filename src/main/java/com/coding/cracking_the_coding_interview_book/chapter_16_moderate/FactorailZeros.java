package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

public class FactorailZeros {
    public static int findZeros(int n){
        int x =5;
        int count=0;
        while(n/x>0){
            count=count+n/x;
            x=x*5;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=100;
        System.out.println(findZeros(n));
    }
}
