package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutationWIthoutDup {
    public static void permutation(String str,Set<String> result,int left, int right)
    {
        if(left==right){
            result.add(str);
        }
        else {
            for (int i = left; i <=right; i++) {
                str = swap(str,left,i);
                permutation(str,result,left+1,right);
                str = swap(str,left,i);

            }
        }

    }
    public static String swap(String s, int i , int j){
        char temp;
        char[] charArray = s.toCharArray();
        temp=charArray[i];
        charArray[i]=charArray[j];
        charArray[j]=temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String s="AABC";
        Set<String> result = new HashSet<>();
        permutation(s,result,0,s.length()-1);
        for(String p: result){
            System.out.println(p);
        }
    }
}
