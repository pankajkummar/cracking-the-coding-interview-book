package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

public class InOrderTraversal {
   public void inOrderTraversal (TreeNode node){
       if(node != null){
           inOrderTraversal(node.left);
           System.out.println(node.val);
           inOrderTraversal(node.right);
       }
   }
}
