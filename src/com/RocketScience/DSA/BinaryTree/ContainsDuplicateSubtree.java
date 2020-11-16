package com.RocketScience.DSA.BinaryTree;

import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
public class ContainsDuplicateSubtree {
    static char MARKER = '$';
    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        String str = dupSub(root);
        if(str.equals(""))
            System.out.print(" Yes ");
        else
            System.out.print(" No ");
    }

    public static String dupSub(Node root)
    {
        HashSet<String> subtrees=new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    public static String dupSubUtil(Node root, HashSet<String> subtrees)
    {
        String s = "";

        // If current node is NULL, return marker
        if (root == null)
            return s + MARKER;

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left,subtrees);
        if (lStr.equals(s))
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right,subtrees);
        if (rStr.equals(s))
            return s;

        // Serialize current subtree
        s = s + root.data + lStr + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 3 as it has two marker
        // nodes.
        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

}
