package com.coding.cracking_the_coding_interview_book.chapter_10_sorting_and_searching;

public class SortedMatrixSearch {
    public static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return new int[]{row,col};

            }
            else if(matrix[row][col]>target){
                col--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        int target = 29;
        int[] result = search(matrix, target);
        if (result[0] != -1) {
            System.out.println("Target found at: (" + result[0] + ", " + result[1] + ")");
        } else {
            System.out.println("Target not found.");
        }
    }
}
