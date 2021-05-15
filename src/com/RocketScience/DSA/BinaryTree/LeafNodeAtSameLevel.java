package com.RocketScience.DSA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
public class LeafNodeAtSameLevel {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(5);
        root.right = new Node(3);
        System.out.println(check(root));
        System.out.println(LeavesAtSameLevel(root,1));
    }

    // Iterative Method
    public static boolean check(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;
        int result = Integer.MAX_VALUE;
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            level++;
            while (size > 0) {
                temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                    if(temp.left.left == null && temp.left.right == null) {
                        if(result == Integer.MAX_VALUE)
                            result = level;
                        else if(result != level)
                            return false;
                    }
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    if(temp.right.left == null && temp.right.right == null){
                        if(result == Integer.MAX_VALUE)
                            result = level;
                        else if(result != level)
                            return false;
                    }
                }
                size--;
            }
        }
        return true;
    }

    // Recursive Method :
    static int leafLevel;
    public static boolean LeavesAtSameLevel(Node root,int level){
        if(root == null)
            return true;

        if(root.left == null && root.right == null){
            if(leafLevel == 0){
                leafLevel = level;
                return true;
            }
            return leafLevel == level;
        }
        return LeavesAtSameLevel(root.left,level+1) && LeavesAtSameLevel(root.right,level+1);
    }
}
