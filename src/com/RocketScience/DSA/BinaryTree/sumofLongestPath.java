package com.RocketScience.DSA.BinaryTree;

//https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
public class sumofLongestPath {
    static int maxSum,maxLen;
    public static void main(String[] args) {
        Node root = new Node(4);         /*        4        */
        root.left = new Node(2);         /*       / \       */
        root.right = new Node(5);        /*      2   5      */
        root.left.left = new Node(7);    /*     / \ / \     */
        root.left.right = new Node(1);   /*    7  1 2  3    */
        root.right.left = new Node(2);   /*      /          */
        root.right.right = new Node(3);  /*     6           */
        root.left.right.left = new Node(6);

        System.out.println(sumofLongRootToLeafPath(root));

    }

    public static int sumofLongRootToLeafPath(Node root){
        if(root == null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;

        sumofLongRootToLeafPathUtil(root,0,0);
        return maxSum;
    }

    private static void sumofLongRootToLeafPathUtil(Node root, int sum, int len) {
        if(root == null){
            if(maxLen < len){
                maxLen = len;
                maxSum = sum;
            }else if(maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }

        sumofLongRootToLeafPathUtil(root.left,sum+root.data, len+1);
        sumofLongRootToLeafPathUtil(root.right,sum+root.data,len+1);
    }
}
