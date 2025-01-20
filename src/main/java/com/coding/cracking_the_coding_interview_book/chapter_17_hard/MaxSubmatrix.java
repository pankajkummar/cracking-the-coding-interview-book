package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;

public class MaxSubmatrix {
    public static int[] findMaxSubmatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = {-1,-1,-1,-1}; // row, col, row_end,col_end
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int r=i; r<row; r++){
                    for(int c=j; c<col; c++){
                        int sum = sumSubmatrix(matrix,i,j,r,c);
                        if(maxSum<sum){
                            maxSum=sum;
                            result[0]=i;
                            result[1]=j;
                            result[2]=r;
                            result[3]=c;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int sumSubmatrix(int[][] matrix, int row, int col, int row_end, int col_end) {
        int sum =0;
        for(int i=row; i<=row_end; i++){
            for(int j=col; j<=col_end; j++){
                sum = sum + matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
       /* int[][] matrix = {
                { 3, -7,  2,  8, -1},
                {-4,  5, -6,  7,  3},
                { 9,  2, -3, -8,  1},
                {-5, -9,  4,  6, -2},
                { 7, -3,  8, -1,  0}
        }; */
        int[][] matrix = {
                {  3, -2,  4,  6, -1,  0, -8,  5, -6,  7,  1,  0,  3,  9, -5, -6, -4, -7,  8, -8,  4, -6, -8, -5,  1, -4,  9, -8, -9, -9,  1,  7,  5,  3, -8,  6,  2, -4,  6,  3,  6,  7,  2, -8, -6, -5,  6, -7,  1,  6},
                {  6,  1, -7, -6,  9, -5,  6,  0,  1, -6,  5, -6, -7,  1, -9, -4, -7, -5, -1, -3,  6,  5,  0,  1, -4,  8,  0,  6, -4, -6, -3,  8,  9,  6,  9,  3,  4, -4,  5,  4, -7,  7,  6,  0, -5,  2, -6,  4, -9, -1},
                { -5, -9,  3, -9, -7, -3, -6,  5,  0,  7,  2, -4,  8, -3, -4,  4,  7,  9, -3,  8,  7,  1, -9, -9, -2, -4,  1,  4, -2,  7, -1,  0,  1,  2, -3, -6,  7, -7, -1,  8,  1, -4, -9, -1, -3, -6, -4,  5,  0, -4},
                { -8, -6, -9,  1,  6, -9,  6, -9,  0, -6,  0, -3,  0,  2, -3, -2, -2, -7,  5,  7,  0, -2,  5,  2,  2,  7, -5,  2,  0, -3,  2,  5,  1,  8,  1,  7, -2, -5,  1,  3, -9,  8, -6,  3, -6, -7,  8,  8, -7, -7},
                {  5, -5, -6, -5,  2,  6, -4, -6, -8,  0, -1, -5,  7,  5, -7,  9, -6,  8,  0, -5, -2, -3,  2,  4,  9,  4, -9, -9,  5, -1, -8, -2,  4,  5,  4,  4,  0, -4, -8, -1,  3, -8, -8,  4, -6, -7, -9, -1, -4,  8},
                { -4, -9, -3,  4,  0, -6, -5, -3, -5,  0, -3, -3,  5, -2,  1, -9,  3, -9,  7,  1, -8,  6, -9, -2, -3, -7,  0,  4,  4,  4,  0, -4, -9,  3,  7, -8, -5, -4, -5, -8, -6, -3,  5, -7, -6,  6,  1,  6, -5,  2},
        {  7,  6,  6,  7,  7, -8,  6,  6, -4,  5, -7, -7, -8, -4,  3, -7, -8, -5, -3,  7, -6, -9,  6,  0,  4,  3, -9,  7, -9,  0,  2,  6,  5, -9, -9,  7, -5, -9,  5, -3,  6, -9, -7, -4, -8,  3,  8, -5, -3, -8,  3},
        {  5, -6,  2, -6, -9, -7,  7, -5, -9, -9,  0,  4, -8,  8, -7, -4, -7, -2,  3, -6, -7, -9,  7, -9, -8,  7, -5, -5,  7, -7, -8, -5,  2,  3, -7, -3,  8, -2,  3,  6, -4, -8, -7, -3, -2,  4,  0,  1, -9,  1,  7}
};
        System.out.println(Arrays.toString(findMaxSubmatrix(matrix)));
    }
}
