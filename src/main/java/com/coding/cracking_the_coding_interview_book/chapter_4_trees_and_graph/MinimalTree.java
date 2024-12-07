package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

public class MinimalTree {
    public TreeNode minimalTree(int[] arr){
        return constructBST(arr,0,arr.length-1);

    }

    private TreeNode constructBST(int[] arr, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = start+ (end-start)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = constructBST(arr,start,mid-1);
        node.right = constructBST(arr,mid+1,end);
        return node;
    }
}
