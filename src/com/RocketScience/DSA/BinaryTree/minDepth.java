package com.RocketScience.DSA.BinaryTree;

public class minDepth { // Leetcode problem
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(minimumDepth(root));
    }

    public static int minimumDepth(Node root) {
        if(root==null ) return 0;
        if(root.left!=null&&root.right!=null)
            return 1+Math.min(minimumDepth(root.left), minimumDepth(root.right));
        if(root.left != null)
            return 1+ minimumDepth(root.left);
        if(root.right != null)
            return 1+ minimumDepth(root.right);
        return 1;
    }
}
