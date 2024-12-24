package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import org.springframework.boot.env.ConfigTreePropertySource;

import java.util.HashMap;
import java.util.Random;

public class MasterMind {
    public static String generateColor(){
        Character[] colors = {'Y','R','G','B'};
        StringBuilder color = new StringBuilder();
        for(int i=0; i<4; i++){
            Random random = new Random();
            int randomNumber = random.nextInt(4);
            color.append(colors[randomNumber]);
        }
        return color.toString();
    }
    public static String score(String color, String guess,String pallet){
        int hit =0;
        int sudohit=0;
        HashMap<Character, Integer> freqColor = new HashMap<>();
        HashMap<Character, Integer> freqGuess = new HashMap<>();
        for(Character c: pallet.toCharArray()){
            freqColor.put(c,0);
            freqGuess.put(c,0);
        }

        for(int i=0; i<color.length(); i++){
            freqGuess.put(guess.charAt(i),freqGuess.get(guess.charAt(i))+1);
            freqColor.put(color.charAt(i),freqGuess.get(color.charAt(i))+1);
            if(color.charAt(i)==guess.charAt(i)){
                hit++;
                freqGuess.put(guess.charAt(i),freqGuess.get(guess.charAt(i))-1);
                freqColor.put(color.charAt(i),freqColor.get(color.charAt(i))-1);
            }
        }
        //count sudo hit
        for(Character c : pallet.toCharArray()){
            sudohit = sudohit+Math.min(freqColor.get(c),freqGuess.get(c));
        }
        return "hit : "+hit+" , sudohit: "+sudohit;
    }

    public static void main(String[] args) {
        String pallet = "RBYG";
        String color = generateColor();
        System.out.println("color : " + color);
        String guess = "BBRY";
        System.out.println("guess : "+ guess);
        String result = score(color,guess,pallet);
        System.out.println(result);
    }
}
