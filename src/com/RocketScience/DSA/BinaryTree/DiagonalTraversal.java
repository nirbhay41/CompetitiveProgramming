package com.RocketScience.DSA.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        printDiagonalTraversal(root);
    }

    public static void printDiagonalTraversal(Node root){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        diagonalTraversal(root,map);
        map.forEach((dist, data) -> System.out.print(dist+"--->"+data+" \n"));
    }
    public static void diagonalTraversal(Node root, HashMap<Integer, ArrayList<Integer>> map){
        class QObj{
            final Node n;
            final int dist;
            QObj(Node t, int dist){
                n = t;
                this.dist = dist;
            }
        }
        Queue<QObj> q = new LinkedList<>();
        q.add(new QObj(root,0));

        while(!q.isEmpty()){
            QObj temp = q.remove();
            if(map.containsKey(temp.dist)){
                map.get(temp.dist).add(temp.n.data);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.n.data);
                map.put(temp.dist,list);
            }
            if(temp.n.left != null)
                q.add(new QObj(temp.n.left,temp.dist+1));

            if(temp.n.right != null)
                q.add(new QObj(temp.n.right,temp.dist));
        }
    }
}
