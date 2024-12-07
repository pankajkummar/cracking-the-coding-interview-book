package com.coding.cracking_the_coding_interview_book.chapter_4_trees_and_graph;


public class Successor {

    public TreeNode findSuccessor(TreeNode node) {
        if (node == null) return null;

        // Case 1: Node has a right child
        if (node.right != null) {
            return getLeftmost(node.right);
        }

        // Case 2: No right child, find the lowest ancestor
        TreeNode current = node;
        TreeNode parent = node.parent;

        while (parent != null && parent.right == current) {
            current = parent;
            parent = parent.parent;
        }

        return parent;
    }

    // Helper function to get the leftmost child
    private TreeNode getLeftmost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        // Build the tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        Successor solution = new Successor();

        // Test cases
        System.out.println("Successor of 15: " + solution.findSuccessor(root.left.right).val); // 20
        System.out.println("Successor of 10: " + solution.findSuccessor(root.left).val); // 15
        System.out.println("Successor of 30: " + solution.findSuccessor(root.right).val); // 35
        System.out.println("Successor of 35: " + solution.findSuccessor(root.right.right)); // null
    }
}
