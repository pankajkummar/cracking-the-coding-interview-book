package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PondSize{

    static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static List<Integer> findPondSizes(int[][] matrix) {
        List<Integer> pondSizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    int size = bfs(matrix, visited, i, j);
                    pondSizes.add(size);
                }
            }
        }

        return pondSizes;
    }

    private static int bfs(int[][] matrix, boolean[][] visited, int startRow, int startCol) {
        int size = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startRow, startCol));
        visited[startRow][startCol] = true;

        // Directions for 8 neighbors (rowOffset, colOffset)
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            size++;

            for (int i = 0; i < 8; i++) {
                int newRow = current.row + rowOffsets[i];
                int newCol = current.col + colOffsets[i];

                if (isValid(matrix, visited, newRow, newCol)) {
                    queue.add(new Point(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return size;
    }

    private static boolean isValid(int[][] matrix, boolean[][] visited, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
                && matrix[row][col] == 0 && !visited[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };

        List<Integer> pondSizes = findPondSizes(matrix);
        System.out.println("Pond Sizes: " + pondSizes);
    }
}
