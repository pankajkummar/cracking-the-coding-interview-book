package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import com.sun.source.tree.BreakTree;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthMultiple {
    public static int findKth(int[] factors,int k){
        if(k<=0) return 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        heap.add(1L);
        seen.add(1L);
        long current = 1;
        for(int i=0; i<k; i++){
            current = heap.poll();
            for(int factor: factors){
                long next = current*factor;
                if(!seen.contains(next)){
                    heap.add(next);
                    seen.add(next);
                }
            }
        }
        return (int)current;
    }

    public static void main(String[] args) {
        int[] factor = {3,5,7};
        System.out.println(findKth(factor, 2));
    }

}
