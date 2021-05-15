package com.RocketScience.DSA.BinaryTree;

public class BalancedTree {
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(4);
        root.right = new Node(20);
        root.right.left = new Node(13);
        root.right.right = new Node(70);

        System.out.println(efficient(root));
    }

    //Time : O(N^2)
    public static boolean naive(Node root){
        if(root == null)
            return true;
        int h1 = BinaryTree.height(root.left); // calculating height takes O(N) time
        int h2 = BinaryTree.height(root.right);
        return Math.abs(h1-h2) <= 1 && naive(root.left) && naive(root.right);
    }
    
    //Time : O(N)
    public static int efficient(Node root){
        if(root == null)
            return 0;
        int lh = efficient(root.left);
        if(lh == -1)
            return -1;
        int rh = efficient(root.right);
        if(rh == -1)
            return -1;
        if(Math.abs(lh-rh) >1)
            return -1;
        else return Math.max(lh,rh)+1; // calculate height along with the method
    }
}
