package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.PriorityQueue;

public class ContinuousMedian {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public ContinuousMedian(){
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    public void addNumber(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if(maxHeap.size() > minHeap.size() +1){
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());

        }
    }
    public double getMedian(){
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        ContinuousMedian medianFinder = new ContinuousMedian();

        int[] numbers = {10, 20, 5, 15, 25};
        for (int num : numbers) {
            medianFinder.addNumber(num);
            System.out.println("Median after adding " + num + ": " + medianFinder.getMedian());
        }
    }
}
