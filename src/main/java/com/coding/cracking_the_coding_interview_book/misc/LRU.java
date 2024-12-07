package com.coding.cracking_the_coding_interview_book.misc;

import java.util.HashMap;

public class LRU {
    private class Node{
        int key,value;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head, tail;
    public LRU(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }
    public void put(int key, int value){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }else{
            Node newNode = new Node(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            if(cache.size() >capacity){
                Node lru = tail.prev;
                cache.remove(lru.key);
                removeNode(lru);
            }
        }
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    private void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRU lruCache = new LRU(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));;
    }
}
