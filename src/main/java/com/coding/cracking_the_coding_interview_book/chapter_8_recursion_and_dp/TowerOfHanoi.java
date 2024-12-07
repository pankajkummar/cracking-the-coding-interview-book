package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

import java.util.Arrays;
import java.util.Stack;

public class TowerOfHanoi {
    public static void moveDisks(int n, Stack<Integer> source, Stack<Integer> destination,Stack<Integer> helper){
        if(n==0){
            return;
        }
        moveDisks(n-1,source,helper,destination);
        System.out.println("moving"+ source.peek()+ "from source to destination");
        destination.push(source.pop());
        moveDisks(n-1,helper,destination,source);

    }

    public static void main(String[] args) {
        int n=3;
        Stack<Integer> tower1 = new Stack<>();
        tower1.addAll(Arrays.asList(3,2,1));
        Stack<Integer> tower2 = new Stack<>();
        Stack<Integer> tower3 = new Stack<>();
        moveDisks(n,tower1,tower3,tower2);
        for (int element : tower3) {
            System.out.println(element);
        }

    }
}
