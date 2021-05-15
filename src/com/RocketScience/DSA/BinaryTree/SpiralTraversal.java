package com.RocketScience.DSA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        traverse2(root);
    }
    
    public static void traverse1(Node root){
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        q.add(root);
        boolean reverse = false;

        while(!q.isEmpty()){
            int cnt = q.size();

            for(int i = 0;i<cnt;i++){
                Node curr = q.remove();
                if(reverse)
                    stack.push(curr.data);
                else System.out.print(curr.data+" ");

                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

            if(reverse){
                while (!stack.isEmpty())
                    System.out.print(stack.pop()+" ");
            }
            reverse = !reverse;
        }
    }

    public static void traverse2(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        boolean rev = true;
        while (!s1.isEmpty()){
            Node curr = s1.pop();
            System.out.print(curr.data+" ");

            if(rev){
                if(curr.left != null)
                    s2.push(curr.left);
                if(curr.right != null)
                    s2.push(curr.right);
            }else{
                if(curr.right != null)
                    s2.push(curr.right);
                if(curr.left != null)
                    s2.push(curr.left);
            }

            if(s1.isEmpty()){
                rev = !rev;
                Stack<Node> temp = s1;
                s1 = s2;
                s2 = temp;
            }
        }
    }
}
