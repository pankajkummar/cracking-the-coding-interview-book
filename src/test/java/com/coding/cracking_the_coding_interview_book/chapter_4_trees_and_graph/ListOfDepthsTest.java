package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOfDepthsTest {
    TreeNode node,nodeUnbalanced;

    ListOfDepths listOfDepths;
    CheckBalanced checkBalanced;

    @BeforeEach
    void setUp() {
        node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        listOfDepths = new ListOfDepths();
        nodeUnbalanced = new TreeNode(1);
        nodeUnbalanced.left = new TreeNode(2);
        nodeUnbalanced.right = new TreeNode(3);
        nodeUnbalanced.left.left = new TreeNode(4);
        nodeUnbalanced.left.right = new TreeNode(5);
        nodeUnbalanced.right.right = new TreeNode(6);
        nodeUnbalanced.right.right.right = new TreeNode(7);
        nodeUnbalanced.right.right.right.right = new TreeNode(8);
        checkBalanced = new CheckBalanced();

    }

    @Test
    void createLevelLinkedListBfs() {
        List<List<Integer>> result = new ArrayList<>();
        result = listOfDepths.createLevelLinkedListBfs(node);
        listOfDepths.printList(result);
    }

    @Test
    void createLevelLinkedListsDfs() {
        List<List<Integer>> result = new ArrayList<>();
        result = listOfDepths.createLevelLinkedListsDfs(node);
        listOfDepths.printList(result);

    }

    @Test
    void CheckBalancedTest1(){
        System.out.println(checkBalanced.isBalanced(node));
        System.out.println(checkBalanced.isBalanced(nodeUnbalanced));
    }
}