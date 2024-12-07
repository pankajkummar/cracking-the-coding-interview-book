package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

public class GraphTraversalDfs {
    public void dfs(int[][] matrix, int start, boolean[] visited) {
        System.out.print(start + " ");
        visited[start] = true;
        for(int i=0; i<matrix[start].length;i++){
            if(matrix[start][i]==1 && !visited[i]){
                dfs(matrix,i,visited);
            }
        }
    }
}
