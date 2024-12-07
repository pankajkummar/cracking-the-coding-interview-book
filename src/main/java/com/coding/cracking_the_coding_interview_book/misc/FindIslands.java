package com.coding.cracking_the_coding_interview_book.misc;

import java.util.Arrays;

public class FindIslands {
    public static int getIslands(int[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
       // Arrays.fill(visited,false);
        int island=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j]==1){
                    exploreAll(i,j,visited,grid);
                    island++;

                }
            }
        }
        return island;

    }

    private static void exploreAll(int i, int j, boolean[][] visited, int[][] grid) {
        if(i>grid.length-1 || j> grid[0].length-1 || i<0 || j<0 || visited[i][j] || grid[i][j]==0){
            return;
        }
        visited[i][j]=true;
        exploreAll(i+1,j,visited,grid);
        exploreAll(i,j+1,visited,grid);
        exploreAll(i-1,j,visited,grid);
        exploreAll(i,j-1,visited,grid);

    return;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println( getIslands(grid));
    }
}
