package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {

    private GraphTraversalBfs bfs;
    private GraphTraversalDfs dfs;
    int[][] matrix;

    @BeforeEach
    void createInstance(){
        bfs = new GraphTraversalBfs();
        dfs = new GraphTraversalDfs();
        matrix = new int[][] {{0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0}};
    }



    @Test
    void dfs() {
        System.out.println("DFS");
        dfs.dfs(matrix,0,new boolean[matrix.length]);
    }
    @Test
    void bfs() {
        System.out.println("BFS");
        bfs.bfs(matrix,0);
    }


}