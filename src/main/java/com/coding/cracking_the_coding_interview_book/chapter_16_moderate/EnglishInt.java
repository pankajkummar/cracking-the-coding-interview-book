package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

public class EnglishInt {
    private static String[] ones = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private static String[] tens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    private static String[] thousands = {"","thousand","million","billion","trillion"};
    public static String intToWord(int n){

        StringBuilder word = new StringBuilder();
        int digit=0;
        if(n<21 && n>0){
            return ones[n];
        }
        while(n>0){
            if(n%1000!=0){
                word.insert(0,helper(n%1000)+thousands[digit]+" ");
            }
            n=n/1000;
            digit++;
        }
        return word.toString();
    }
    private static String helper(int n){
        if(n==0) return "";
        else if(n<20) return  ones[n]+ " ";
        else if(n<100) return  tens[n/10]+ " "+helper(n%10);
        else return ones[n/100]+" Hundred " + helper(n%100);
    }

    public static void main(String[] args) {
        int number = 11111111;
        System.out.println(intToWord(number));

    }
}
