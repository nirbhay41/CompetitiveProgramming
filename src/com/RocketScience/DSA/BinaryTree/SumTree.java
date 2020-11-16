package com.RocketScience.DSA.BinaryTree;

//https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class SumTree {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println(toSumTree(root));
        printInorder(root);
    }
    static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private static int toSumTree(Node root){
        if (root == null)
            return 0;
        int oldValue = root.data;

        root.data = toSumTree(root.left) + toSumTree(root.right);

        return root.data + oldValue;
    }
}
