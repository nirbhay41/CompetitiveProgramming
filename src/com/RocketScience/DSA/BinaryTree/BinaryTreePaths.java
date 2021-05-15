package com.RocketScience.DSA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        binaryTreePaths(root).forEach(System.out::println);
    }

    public static List<String> binaryTreePaths(Node root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(list,root,sb);

        return list;
    }
    public static void helper(List<String> list, Node root, StringBuilder sb){
        if(root == null)
            return;
        int len = sb.length();
        sb.append(root.data);

        if(root.left == null && root.right == null){
            list.add(sb.toString());
        }else{
            sb.append("->");
            helper(list,root.left,sb);
            helper(list,root.right,sb);
        }
        sb.setLength(len);
    }
}
