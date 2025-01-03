package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

public class AddWithoutPlus {
    public static int add(int a, int b){
        int result=0;
        while(b!=0){
            int sumWithoutCarry = a ^ b;
            int carry = (a & b) << 1;
            a = sumWithoutCarry;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(3,6));
    }
}
