package com.coding.cracking_the_coding_interview_book.chapter_1_arrays_and_strings;

public class OneAway {
    public Boolean isOneAway(String s1, String s2){
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        if(s1.length()<s2.length()){
            return insert(s1,s2);
        }
        else if (s1.length()>s2.length()) {
            return remove(s1,s2);
        }
        else{
            return replace(s1,s2);
        }

    }
    public Boolean insert(String s1, String s2){
        int i=0,j=0,insert=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
                insert++;
                if(insert>1){
                    return false;
                }
            }

        }
       return true;
    }
    public Boolean remove(String s1, String s2){
        int i=0,j=0,remove=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
                remove++;
                if(remove>1){
                    return false;
                }
            }

        }
        return true;
    }
    public Boolean replace(String s1,String s2){
        int i=0,j=0,replace=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
                i++;
                replace++;
                if(replace>1){
                    return false;
                }
            }

        }
        return true;
    }

}
