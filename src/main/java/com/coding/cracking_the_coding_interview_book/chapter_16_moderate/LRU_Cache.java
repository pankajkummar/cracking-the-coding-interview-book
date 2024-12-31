package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LRU_Cache {
    private int maxCacheSize;
    private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
    private LinkedListNode listHead = null;
    private LinkedListNode listTail = null;

    public LRU_Cache(int size){
        maxCacheSize=size;
    }

    private static class LinkedListNode{
        private LinkedListNode next,prev;
        public int key;
        public String value;
        public LinkedListNode(int k, String v){
            key = k;
            value = v;
        }
    }
    //retreive value
    public String getValue(int key){
        LinkedListNode item = map.get(key);
        if(item==null) return  null;
        if(item != listHead){
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }
        return item.value;
    }

    // remove value from list

    private void removeFromLinkedList(LinkedListNode node){
        if(node == null) return;
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
        if(node == listTail) listTail = node.prev;
        if(node == listHead) listHead = node.next;
    }

    // Insert node at front of the linkedList

    private void insertAtFrontOfLinkedList(LinkedListNode node){
        if(listHead==null){
            listHead = node;
            listTail = node;
        }else{
            listHead.prev = node;
            node.next = listHead;
            listHead = node;
        }
    }

    // removing value from cache
    public boolean removeKey(int key){
        LinkedListNode node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    // put key value pair in cache

    public void setKeyValue(int key, String value){
        removeKey(key);
        if(map.size() >= maxCacheSize && listTail!=null){
            removeKey(listTail.key);
        }
        LinkedListNode node = new LinkedListNode(key,value);
        insertAtFrontOfLinkedList(node);
        map.put(key,node);
    }

    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(3);
        cache.setKeyValue(4,"apple");
        cache.setKeyValue(2,"mango");
        cache.setKeyValue(1,"papaya");
        System.out.println(cache.getValue(4));
        cache.setKeyValue(5,"guava");
        System.out.println(cache.getValue(4));
    }

}
