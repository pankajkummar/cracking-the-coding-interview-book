package com.coding.cracking_the_coding_interview_book.misc;

import static java.util.Collections.rotate;

public class StringObsfucation {
    public static String findSmallest(String message){
        String s=message;
        for(int i=0; i<message.length(); i++){
            for(int j=i; j<message.length(); j++){
                String str = message.substring(0,i)+rotateString(message.substring(i,j))+message.substring(j,message.length());
            }
        }
        return s;
    }

    private static String rotateString(String substring) {
    if(substring.length()<=1){
        return substring;
    }
    return substring;
    }
}
