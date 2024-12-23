package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.*;

public class DivingBoard {
    public static Set<Integer> generateSize(int sizeSmall, int sizeLarge, int k){
       // List<Integer> sizes = new ArrayList<>();
        Set<Integer> sizes = new TreeSet<>(); // maintain order
        for(int i=0; i<=k; i++){
            sizes.add(i*sizeSmall+(k-i)*sizeLarge);
        }
        return sizes;
    }

    public static void main(String[] args) {
        int sizeSmall = 10, sizeLarge = 10, k=20;
        Set<Integer> size = generateSize(sizeSmall,sizeLarge,k);
        System.out.println(size);

    }
}
