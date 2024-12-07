package com.coding.cracking_the_coding_interview_book.chapter_8_recursion_and_dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RobotInGrid {
    public ArrayList<String> findPath(int[][] matrix){
        if(matrix==null || matrix.length==0){
            return null;
        }
        ArrayList<String> path = new ArrayList<>();
        HashSet<String> failedPoints = new HashSet<>();
        if(getPath(matrix,matrix.length-1,matrix[0].length-1,path,failedPoints)){
            return path;
        }
        return null;
    }

    private boolean getPath(int[][] matrix, int row, int col, ArrayList<String> path, HashSet<String> failedPoints) {
        if(col<0 || row<0 || matrix[row][col] !=0){
            return false;
        }
        String p = "("+Integer.toString(row)+","+Integer.toString(col)+")";

        boolean isAtOrgin = (row==0)&&(col==0);
        if(isAtOrgin ){

            return true;
        }
        path.add(p);
        getPath(matrix,row-1,col,path,failedPoints);
        getPath(matrix,row,col-1,path,failedPoints);
        //failedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        };
        System.out.println(matrix);
        RobotInGrid robotInGrid = new RobotInGrid();
        List<String> result = robotInGrid.findPath(matrix);
       // result.toString();
        if(result !=null) {
            System.out.println(result.toString());
        }
        else{
            System.out.println("path not available");
        }



    }
}
