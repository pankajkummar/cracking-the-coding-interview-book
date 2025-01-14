package com.coding.cracking_the_coding_interview_book.chapter_17_hard.efficientStringMatchingAlogirthms;

import jdk.dynalink.beans.StaticClass;

import java.lang.module.FindException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/*
A trie (also known as a prefix tree) is a specialized tree-like data structure that is particularly effiecient for stroring and searching string. It is
comonly used for task such as autocomplete, spell checking and prefix-based searching
Each node represents a single character of a string
Strings are stored character by character along a path in the tree
* A trie can find all words with a given prefix.
* searching for a word or prefix takes O(L) where L is the length of the word
* Each node have a marker or flag indicating end of a valid word
 */
public class Trie {
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a'; // Map 'a' to o, 'b' to 1 .. 'z' to 25
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord=true;
    }
    //search for a complete word in trie
    public boolean search(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            int index = ch -'a';
            if(current.children[index]==null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    //check if there is any word in the trie that starts with given prefix
    public boolean startsWith(String prefix){
        TrieNode current = root;
        for(char ch: prefix.toCharArray()){
            int index = ch='a';
            if(current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
    // find all words in the Trie that start with a given prefix
    public List<String> findWordsWithPrefix(String prefix){
        TrieNode current = root;
        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';
            if(current.children[index] == null ){
                return new ArrayList<>();
            }
            current = current.children[index];
        }
        List<String> result = new ArrayList<>();
        dfs(current,new StringBuilder(prefix),result);
        return result;
    }
    //dfs helper function
    private void dfs(TrieNode node,  StringBuilder path, List<String> result){
        if(node.isEndOfWord){
            result.add(path.toString());
        }
        for(char ch='a'; ch<='z'; ch++){
            int index = ch - 'a';
            if(node.children[index] != null){
                path.append(ch);
                dfs(node.children[index],path,result);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
