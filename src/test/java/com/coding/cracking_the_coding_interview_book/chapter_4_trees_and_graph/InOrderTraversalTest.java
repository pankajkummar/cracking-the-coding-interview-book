package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InOrderTraversalTest {
    private TreeNode root;
    private InOrderTraversal inOrderTraversal;
    @BeforeEach
    void createInstance(){
        inOrderTraversal = new InOrderTraversal();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

    }

    @Test
    void inOrderTraversal() {
        inOrderTraversal.inOrderTraversal(root);
    }
}