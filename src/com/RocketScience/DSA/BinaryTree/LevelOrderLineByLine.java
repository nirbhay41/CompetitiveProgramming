package com.RocketScience.DSA.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLineByLine {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);

        levelOrder2(root);
    }

    public static void levelOrder1(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1){
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.data+" ");
            if(curr.left != null)
                q.add(curr.left);
            if(curr.right != null)
                q.add(curr.right);
        }
    }

    public static void levelOrder2(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();

            for(int i = 0;i<count;i++){
                Node curr = q.remove();

                System.out.print(curr.data+" ");
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }
}
