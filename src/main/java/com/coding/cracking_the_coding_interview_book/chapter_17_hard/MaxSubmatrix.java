package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;
// sum subarray dp[i][j]= matrix[i][j] + (if i>0 dp[i-1][j]+ if j>0 dp[i][j-1] + if i>0 and j>0 -dp[i-1][j-1];
public class MaxSubmatrix {
    public static int[] findMaxSubmatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = {-1,-1,-1,-1,-1}; // row, col, row_end,col_end
        int[][] dp = calculateDpMatrix(matrix);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                for(int i2=i; i2<row; i2++){
                    for(int j2=j; j2<col; j2++){
                      //  int sum = sumSubmatrix(matrix,i,j,r,c);
                        int sum = dp[i2][j2] - (i>0 ? dp[i-1][j2] : 0) +-(j>0 ? dp[i2][j-1] : 0) + ((i>0 && j>0) ? dp[i-1][j-1]:0);
                        if(maxSum<sum){
                            maxSum=sum;
                            result[0]=i;
                            result[1]=j;
                            result[2]=i2;
                            result[3]=j2;
                            result[4]=sum;
                        }
                    }
                }
            }
        }
        return result;
    }
    private static int[][] calculateDpMatrix(int[][] matrix){
        // dp[i][j] = matrix[i][j] + dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                dp[i][j] = matrix[i][j] + (i>0 ? dp[i-1][j] : 0) + (j>0 ? dp[i][j-1] : 0) - (i>0 && j>0 ? dp[i-1][j-1] : 0);
            }
        }
        return dp;
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
        int[][] matrix = {
                { 3, -7,  2,  8, -1},
                {-4,  5, -6,  7,  3},
                { 9,  2, -3, -8,  1},
                {-5, -9,  4,  6, -2},
                { 7, -3,  8, -1,  0}
        };
        System.out.println(Arrays.deepToString(calculateDpMatrix(matrix)));
      //  System.out.println(Arrays.toString(findMaxSubmatrix(matrix)));
    }
}
