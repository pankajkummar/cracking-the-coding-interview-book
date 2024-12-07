package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;

import java.util.*;

public class ListOfDepths {
    public List<List<Integer>> createLevelLinkedListBfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            result.add(currentLevel);

        }
        return result;
    }

    public List<List<Integer>> createLevelLinkedListsDfs(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(root,0,result);
        return result;

    }

    private void dfsHelper(TreeNode node , int depth, List<List<Integer>> result) {
        if(node==null){
            return;
        }
        if(result.size() == depth){
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        dfsHelper(node.left,depth+1,result);
        dfsHelper(node.right,depth+1,result);
    }
    public void printList(List<List<Integer>> lists){
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("Depth " + i + ": " + lists.get(i));
        }
    }
}
