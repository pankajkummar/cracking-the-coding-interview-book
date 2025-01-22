package com.coding.cracking_the_coding_interview_book.misc;

import java.util.HashMap;

public class LongestStringWithKCharacters {
    public static String findString(String str,int k){
        int pointer1=0;
        int pointer2=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength=-1;
        String result="";
        while(pointer2<str.length()){

            char pointer2_char = str.charAt(pointer2);
            if(map.containsKey(pointer2_char) || map.size()<k){
                int count = map.getOrDefault(pointer2_char, 0);
                map.put(pointer2_char, count+1);
                pointer2++;
                if(pointer2-pointer1>maxLength){
                    maxLength=pointer2-pointer1;
                    result=str.substring(pointer1, pointer2);
                }
            } else {
                while (map.size()==k){
                    char pointer1_char = str.charAt(pointer1);
                    int count = map.getOrDefault(pointer1_char, 0);
                    if(count==1){
                        map.remove(pointer1_char);
                        pointer1++;
                    }
                    else{
                        map.put(pointer1_char, count-1);
                        pointer1++;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abababbbbbbbbbccccccdddddddddecedddddd";
        System.out.println(findString(s,3));
    }
}
