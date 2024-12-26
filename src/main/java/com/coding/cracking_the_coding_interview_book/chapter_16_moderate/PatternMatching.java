package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

public class PatternMatching {
    public static Boolean isMatch(String str, String pattern){
        String subStringA="";
        String subStringB="";

        for(int starta=0; starta<str.length(); starta++){
            for(int enda=starta+1; enda<=str.length(); enda++){
                subStringA=str.substring(starta,enda);
                for(int startb=0; startb<str.length(); startb++){
                    for(int endb=startb+1; endb<=str.length(); endb++){
                        subStringB = str.substring(startb,endb);
                        String candidate = buildPattern(pattern,subStringA,subStringB);
                        if(candidate.equalsIgnoreCase(str)){
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    private static String buildPattern(String pattern, String subStringA, String subStringB) {
        StringBuilder str = new StringBuilder();
        char first = pattern.charAt(0);
        for(char c: pattern.toCharArray()){
            if(c==first){
                str.append(subStringA);
            }else{
                str.append(subStringB);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "catcatgocatgo";
        String pattern = "ab";
        System.out.println(isMatch(str,pattern));
    }
}
