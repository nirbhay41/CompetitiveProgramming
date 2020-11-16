package com.RocketScience.DSA.BinaryTree;

import java.util.Stack;

//https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
public class treeFromString {
    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        Node root = makeTree(s);
        preorder(root);
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    public static Node makeTree(String s){  // O(n^2)
        if(s == null || s.length() == 0)
            return null;
        return makeUtil(s,0,s.length()-1);
    }
    public static Node makeUtil(String s,int si,int ei) {
        if(si > ei)
            return null;
        Node root = new Node(s.charAt(si) - '0');
        int index = -1;

        if(si+1 <= ei && s.charAt(si+1) == '(')
            index = findIndex(s,si+1,ei);
        if(index != -1){
            root.left  = makeUtil(s,si+2,index-1);
            root.right = makeUtil(s,index+2,ei-1);
        }
        return root;
    }

    private static int findIndex(String s, int si, int ei) {
        if(si > ei)
            return -1;

        Stack<Character> stack = new Stack<>();

        for(int i = si;i<=ei;i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(stack.peek() == '(')
                    stack.pop();
                if(stack.isEmpty())
                    return i;
            }
        }
        return -1;
    }
}
