package com.RocketScience.DSA.BinaryTree;

import java.util.Vector;

//https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class PrintAllKSumPaths {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 5;
        printKPathUtil(root, k);
    }
    static Vector<Integer> path = new Vector<Integer>();

    // This function prints all paths that have sum k
    static void printKPathUtil(Node root, int k) {
        if (root == null)
            return;
        path.add(root.data);

        // check if there's any k sum path
        // in the left sub-tree.
        printKPathUtil(root.left, k);

        // check if there's any k sum path
        // in the right sub-tree.
        printKPathUtil(root.right, k);

        // check if there's any k sum path that
        // terminates at this node
        // Traverse the entire path as
        // there can be negative elements too
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);

            // If path sum is k, print the path
            if (f == k)
                printVector(path, j);
        }

        // Remove the current element from the path
        path.remove(path.size() - 1);
    }

    static void printVector(Vector<Integer> v, int i){
        for (int j = i; j < v.size(); j++)
            System.out.print( v.get(j) + " ");
        System.out.println();
    }
}