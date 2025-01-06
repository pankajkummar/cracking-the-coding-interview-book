package com.coding.cracking_the_coding_interview_book.chapter_17_hard.UnionFind;

public class UnionFindDemoPair {
    public static void main(String[] args) {
        UnionFind<String> unionFind = new UnionFind<>();
        unionFind.add("john");
        unionFind.add("jon");
        unionFind.add("johnny");
        unionFind.add("Chris");
        unionFind.add("kris");
        unionFind.add("Christopher");
        unionFind.union("jon", "john");
        unionFind.union("john", "johnny");
        unionFind.union("Chris", "kris");
        unionFind.union("Chris", "Christopher");
        System.out.println(unionFind.connected("jon", "johnny"));
        System.out.println("Root of jon : "+ unionFind.find("jon"));
        System.out.println("Root of johnny : "+unionFind.find("johnny"));
    }
}
