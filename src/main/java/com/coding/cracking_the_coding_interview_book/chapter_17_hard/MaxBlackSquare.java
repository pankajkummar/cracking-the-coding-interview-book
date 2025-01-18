package com.coding.cracking_the_coding_interview_book.chapter_17_hard;

import java.util.Arrays;

public class MaxBlackSquare {
    public static int[] findMaxBlackSquare(int[][] matrix){
        int side = matrix.length;
        int[] result = {-1,-1,-1}; // row col length
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                for(int length=1; length< matrix.length-i; length++){
                    if(isAllBlack(i, j, matrix, length)){
                        if(length>maxLength){
                            maxLength = length;
                            result[0]=i;
                            result[1]=j;
                            result[2]=length;
                        }
                    }
                }
            }
        }
    return result;
    }
    public static boolean isAllBlack(int i, int j, int[][] matrix,int length){
        if(i< 0 || j<0 || i+length >= matrix.length || j+length >= matrix.length)
        {
            return false;
        }
        //checked top row
        for(int k=j;k<j+length;k++){
            if(matrix[i][k]!=1){
                return false;
            }
        }
        // top row to right downward
        for(int k=i;k<i+length;k++){
            if(matrix[k][j+length]!=1){
                return false;
            }
        }
        // bottom row right to left
        for(int k=j+length;k>j;k--){
            if(matrix[i+length][k]!=1){
                return false;
            }
        }
        // left column down to up
        for(int k=i+length;k>i;k--){
            if(matrix[k][j]!=1){
                return false;
            }
        }
    return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 0, 0}
        };
        System.out.println(Arrays.toString(findMaxBlackSquare(matrix)));
    }
}
