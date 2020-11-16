package com.RocketScience.DSA.BinaryTree;

public class CheckIfSumTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(2);

        System.out.println(isSumTree2(root));
       // System.out.println(isSumTree1(root));
    }
    
    //Method I -- O(n^2) :
    public static boolean isSumTree1(Node root){
        if(root == null || (root.left == null && root.right == null))
            return true;
        int ls = add(root.left);
        int rs = add(root.right);

        if(root.data == ls+rs)
            return isSumTree1(root.left) && isSumTree1(root.right);

        return false;
    }
    public static int add(Node root){
        if(root == null)
            return 0;
        return root.data + add(root.left) + add(root.right);
    }

    //Method -2 O(n) :

    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    public static boolean isSumTree2(Node root){
        int ls,rs;

        if(root == null || isLeaf(root))
            return true;

        if(isSumTree2(root.left) && isSumTree2(root.right)){
            if(root.left == null)
                ls = 0;
            else if(isLeaf(root.left))
                ls = root.left.data;
            else ls = 2*root.left.data;

            if(root.right == null)
                rs = 0;
            else if(isLeaf(root.right))
                rs = root.right.data;
            else rs = 2*root.right.data;

            return root.data == ls+rs;
        }
        return false;
    }

}
