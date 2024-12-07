package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversalBfs {
    public void bfs(int[][] matrix, int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int i=0; i<matrix[current].length; i++){
                if(matrix[current][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
            }

        }
    }
}
