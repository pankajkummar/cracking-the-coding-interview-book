package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class XmlEncoding {
    public static String xmlEncoding(String xml, HashMap<String,Integer> map){
        String[] splitXml = xml.split("(?=[<>\"=\\s])|(?<=[<>\"=\\s])");
        StringBuilder encoding = new StringBuilder();
        int index=0;
        for(String word: splitXml){
            if(map.containsKey(word)){
                encoding.append(map.get(word)).append(" ");
            }
            else if(!map.containsKey(word) && (word.matches("[a-zA-Z]+") || word.matches("[0-9]+"))){
                encoding.append(word).append(" ");
            }
            else if(!map.containsKey(word) && Objects.equals(word, ">")){
                encoding.append("0 ");
            }


        }
        return encoding.toString();
    }

    public static void main(String[] args) {
        String xml = """
                <family lastName="McDowell" state="CA">
                <person firstName="Gayle"> Some Message</person>
                </family>
                """;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("family",1);
        map.put("person",2);
        map.put("firstName",3);
        map.put("lastName",4);
        map.put("state",5);
        String encode = xmlEncoding(xml,map);

        System.out.println(encode);
    }
}
