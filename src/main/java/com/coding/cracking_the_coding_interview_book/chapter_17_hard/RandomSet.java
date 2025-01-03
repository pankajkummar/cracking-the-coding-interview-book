package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.*;

public class RandomSet {
    public static int[] generateSet(int[] arr, int m){
        int k=0;
        int[] set = new int[m];
        Random rand = new Random();
        Set<Integer> taken = new HashSet<>();
        while(k<m){
            int random = rand.nextInt(arr.length);
            if(!taken.contains(random)){
                taken.add(random);
                set[k]=arr[random];
                k++;
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for(int i=0; i<52; i++){
            deck[i] = i+1;
        }
        System.out.println(Arrays.toString(generateSet(deck,7)));
    }
}
