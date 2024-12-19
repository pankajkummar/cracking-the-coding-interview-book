package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

public class NumberSwapperWithoutTemp {
    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
    }

    public static void main(String[] args) {
        int a = 5, b=7;
        swap(a,b); // wond work because its pass by value use int[]
        System.out.println("a = "+a+", b = "+b);
    }
}
