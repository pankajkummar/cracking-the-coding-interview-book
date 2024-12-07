package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

public class CheckBalanced {
    public Boolean isBalanced(TreeNode root){
        int result = height(root);
        System.out.println(" height :"+result);

        return result!=-1;

    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
      /*  if(leftHeight== -1 || rightHeight== -1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        } */
        return Math.max(leftHeight,rightHeight)+1;
    }
}
