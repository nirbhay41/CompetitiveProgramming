package com.RocketScience.DSA.BinaryTree;

public class DiameterOfBT {
    public static void main(String[] args) {

    }

    static class A{
        int ans = Integer.MIN_VALUE;
    }

    private static int heigthD(Node root,A a){
        if(root == null)
            return 0;
        int ldepth = heigthD(root.left,a);
        int rdepth = heigthD(root.right,a);

        a.ans = Math.max(a.ans,1+ldepth+rdepth);
        return 1+Math.max(ldepth,rdepth);
    }
    public static int diameter(Node root){
        A a = new A();
        int temp = heigthD(root,a);
        return a.ans;
    }
}
