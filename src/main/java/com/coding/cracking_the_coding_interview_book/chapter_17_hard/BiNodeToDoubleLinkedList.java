package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import com.coding.cracking_the_coding_interview_book.chapter_17_hard.utility.Pair;

public class BiNodeToDoubleLinkedList {
    static class Result {
        BiNode head;
        BiNode tail;
    }
    public static Result convertToDoublyLinkedList(BiNode root){
        if(root==null) return  new Result();

        Result leftResult = convertToDoublyLinkedList(root.node1);
        Result rightResult = convertToDoublyLinkedList(root.node2);
        if(leftResult.tail != null){
            leftResult.tail.node2 = root;
            root.node1 = leftResult.tail;
        }
        if(rightResult.head != null){
            rightResult.head.node1 = root;
            root.node2 = rightResult.head;
        }

        Result result = new Result();
        result.head = leftResult.head !=null ? leftResult.head : root;
        result.tail = rightResult.tail !=null ? rightResult.tail : root;
        return result;
    }
    public static void printDoublyLinkedList(BiNode head){
        BiNode current = head;
        while(current!=null) {
            System.out.print(current.data + " ");
            current = current.node2;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BiNode root = new BiNode(4);
        root.node1 = new BiNode(2);
        root.node2 = new BiNode(6);
        root.node1.node1 = new BiNode(1);
        root.node1.node2 = new BiNode(3);
        root.node2.node1 = new BiNode(5);
        root.node2.node2 = new BiNode(7);

        // Convert BST to DLL
        Result result = convertToDoublyLinkedList(root);

        // Print the doubly linked list
        printDoublyLinkedList(result.head);
    }
}
