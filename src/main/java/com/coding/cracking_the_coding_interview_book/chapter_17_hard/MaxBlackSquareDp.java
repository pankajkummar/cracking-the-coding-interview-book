package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
//incomplete
public class MaxBlackSquareDp {
    public static int[] findMaxBlackSquare(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSize = 0;
        int[] result = {-1, -1, -1}; // row, col, size

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // Boundary cells
                        dp[i][j] = 1;
                    } else {
                        // Main DP formula
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }

                    // Update the result if a larger square is found
                    if (dp[i][j] > maxSize) {
                        maxSize = dp[i][j];
                        result[0] = i - maxSize + 1; // Top-left row
                        result[1] = j - maxSize + 1; // Top-left col
                        result[2] = maxSize;         // Size of the square
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 0, 0}
        };

        System.out.println("Max Black Square: " + Arrays.toString(findMaxBlackSquare(matrix)));
    }
}