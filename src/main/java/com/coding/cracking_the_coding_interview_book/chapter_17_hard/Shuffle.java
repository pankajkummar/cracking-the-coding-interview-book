package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public static int[] shuffleDeck(int[] deck){
        Random rand = new Random();
        for(int i=deck.length-1; i>=0; i--){
            int random = rand.nextInt(i+1);
            int temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
        return deck;
    }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for(int i=0; i<52; i++){
            deck[i] = i+1;
        }
        System.out.println(Arrays.toString(shuffleDeck(deck)));
    }
}
