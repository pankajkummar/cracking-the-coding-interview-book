package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

public class Count2s {
    public static int count(int n){
        int count=0;
        for(int i=2; i<=n; i++){
            int x=i;
            if(i>10) {
                while (x > 1) {
                    int m = x % 10;
                    if (m == 2) {
                        count++;
                    }
                    x = x / 10;
                }
            }else{
                if(i==2){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n=25;
        System.out.println(count(n));
    }
}
