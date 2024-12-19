package com.coding.cracking_the_coding_interview_book.chapter_16_moderate;

public class tic_tac_win {
    public static int winner(int[][] matrix){
        if(checkColumn(matrix,0) || checkRow(matrix,0) || checkDiagonal(matrix,0)){
            return 0;
        }
        else if(checkColumn(matrix,1) || checkRow(matrix,1) || checkDiagonal(matrix,1)){
            return 1;
        }
        return -1;
    }
    public static boolean checkRow(int[][] matrix, int value){
        for(int i=0;i<matrix.length;i++){
            int count=0;
            for(int j=0; j<matrix.length;j++){
                if(matrix[i][j]==value){
                    count++;
                }
                if(count==matrix.length){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkColumn(int[][] matrix, int value){
        for(int i=0;i<matrix.length;i++){
            int count=0;
            for(int j=0; j<matrix.length;j++){
                if(matrix[j][i]==value){
                    count++;
                }
                if(count==matrix.length){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkDiagonal(int[][] matrix, int value){
        int row=0,digonal2_row=matrix.length-1;
        int col=0;
        int count1=0;
        int count2=0;
        while(row<matrix.length && digonal2_row>=0 && col<matrix.length){
            if(matrix[row][col]==value){
                count1++;
            }
            if(matrix[digonal2_row][col]==value){
                count2++;
            }
            if(count1== matrix.length || count2== matrix.length){
                return true;
            }
            row++;
            digonal2_row--;
            col++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,1,0},{0,1,0}};
        System.out.println(winner(matrix));
    }

}
