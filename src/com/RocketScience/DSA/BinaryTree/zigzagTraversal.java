package com.RocketScience.DSA.BinaryTree;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
public class zigzagTraversal {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }
    
    static void zigZagTraversal(Node root){
        if(root == null)
            return;
        Stack<Node> currentLevel = new Stack<>(),nextLevel = new Stack<>();
        currentLevel.push(root);
        Node temp;
        boolean leftToRight = true;
        while(!currentLevel.isEmpty()){
            temp = currentLevel.pop();
            System.out.print(temp.data+" ");
            if(leftToRight){
                if(temp.left != null)
                    nextLevel.push(temp.left);
                if(temp.right != null)
                    nextLevel.push(temp.right);
            }else{
                if(temp.right != null)
                    nextLevel.push(temp.right);
                if(temp.left != null)
                    nextLevel.push(temp.left);
            }
            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> s = currentLevel;
                currentLevel = nextLevel;
                nextLevel = s;
            }
        }
    }
}
