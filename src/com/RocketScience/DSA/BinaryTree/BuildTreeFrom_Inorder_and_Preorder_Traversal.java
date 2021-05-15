package com.RocketScience.DSA.BinaryTree;

import java.util.HashMap;

public class BuildTreeFrom_Inorder_and_Preorder_Traversal {
    public static void main(String[] args) {
        int[] in = {1,6,8,7};
        int[] pre = {1,6,7,8};

        Node root = buildTreeWrap(in,pre,in.length);
        BinaryTree.inorder(root);
    }
    //Method - 1 O(n^2) :
    static int pindex = 0;
    public static Node buildTree1(int[] in, int[] pre, int start, int end){
        if(start > end)
            return null;
        Node root = new Node(pre[pindex++]);

        if(start == end)
            return root;

        int index = search(in,start,end,root.data);
        root.left = buildTree1(in,pre,start,index-1);
        root.right = buildTree1(in,pre,index+1,end);

        return root;
    }

    private static int search(int[] in, int start, int end, int data) {
        int i;
        for (i = start;i<=end;i++){
            if(in[i] == data)
                return i;
        }
        return i;
    }

    //Method - 2 Use HashMap to search in O(1) time :
    public static Node buildTreeWrap(int[] in,int[] pre,int len){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<len;i++)
            map.put(in[i],i);
        return buildTree2(in,pre,0,len-1,map);
    }

    public static Node buildTree2(int[] in, int[] pre, int start, int end, HashMap<Integer,Integer> map){
        if(start > end)
            return null;
        Node root = new Node(pre[pindex++]);

        if(start == end)
            return root;

        int index = map.get(root.data);
        root.left = buildTree1(in,pre,start,index-1);
        root.right = buildTree1(in,pre,index+1,end);

        return root;
    }

}
