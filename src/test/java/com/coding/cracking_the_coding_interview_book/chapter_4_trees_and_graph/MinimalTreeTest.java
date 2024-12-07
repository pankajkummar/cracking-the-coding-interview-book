package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import com.jayway.jsonpath.internal.function.numeric.Min;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimalTreeTest {
    private MinimalTree minimalTree;
    private InOrderTraversal inOrderTraversal;
    @BeforeEach
    void createInstance(){
        minimalTree = new MinimalTree();
        inOrderTraversal = new InOrderTraversal();

    }

    @Test
    void minimalTree() {
        int[] arr= {1,2,3,4,5,6,7};
        TreeNode node = minimalTree.minimalTree(arr);
        inOrderTraversal.inOrderTraversal(node);

    }
}