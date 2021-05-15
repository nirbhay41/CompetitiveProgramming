package com.RocketScience.DSA.BinaryTree;

public class BoundaryPrint {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        printBoundary(root);
    }
    public static void printBoundary(Node root){
        if(root == null)
            return;
        System.out.print(root.data +" ");
        printLeftBoundary(root.left);
        printLeafNodes(root.left);
        printLeafNodes(root.right);
        printRightBoundary(root.right);
    }

    private static void printRightBoundary(Node root){ // printing from bottom to top
        if(root == null)
            return;
        if(root.right != null) {
            printRightBoundary(root.right);
            System.out.print(root.data+" ");
        }else if(root.left != null){
            printRightBoundary(root.left);
            System.out.print(root.data+" ");
        }
    }

    private static void printLeafNodes(Node root){
        if (root == null)
            return;
        printLeafNodes(root.left);
        if(root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeafNodes(root.right);
    }

    private static void printLeftBoundary(Node root){ // printing from top to bottom
        if(root == null)
            return;
        if(root.left != null) {
            System.out.print(root.data+" "); // This statement is inside if due to leaf nodes
            printLeftBoundary(root.left);
        }else if(root.right != null){
            System.out.print(root.data+" "); // This statement is inside if due to leaf nodes
            printLeftBoundary(root.right);
        }
    }
}
