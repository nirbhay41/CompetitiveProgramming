package com.RocketScience.DSA.BinaryTree;

import java.util.*;

class Node{
    public int data;
    public Node left,right;
    public Node(int key){
        data = key;
        left = right = null;
    }
}

public class BinaryTree {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(6);

        reverseLevelOrder(root);
    }

    public static Node create(){
        Node root,p,t;
        int x;
        Queue<Node> q = new LinkedList<>();
        System.out.println("Enter root node value: ");
        root = new Node(sc.nextInt());
        q.add(root);
        while(!q.isEmpty()){
            p = q.remove();
            System.out.printf("Enter left child of %d: ",p.data);
            x = sc.nextInt();

            if(x != -1){
                t = new Node(x);
                p.left = t;
                q.add(t);
            }
            System.out.printf("Enter right child of %d: ",p.data);
            x = sc.nextInt();

            if(x != -1){
                t = new Node(x);
                p.right = t;
                q.add(t);
            }
        }
        return root;
    }

    public static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public static void preorder(Node root){
        if(root != null){
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    public static void iter_inorder(Node root){
        Stack<Node> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    public static void iter_preorder(Node root){
        Stack<Node> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            if(root != null){
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void iter_postorder(Node root){
        if(root == null)
            return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            root = s1.pop();
            s2.push(root);
            if(root.left != null)
                s1.push(root.left);
            if(root.right != null)
                s1.push(root.right);
        }

        while(!s2.isEmpty()){
            System.out.println(s2.pop().data);
        }
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            root = q.remove();
            System.out.print(root.data+" ");
            if(root.left != null)
                q.add(root.left);
            if(root.right != null)
                q.add(root.right);
        }
    }
    
    public static void reverseLevelOrder(Node root){
        Stack<Node> stack = new Stack<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        Node temp;
        while (!q.isEmpty()){
            temp = q.poll();
            stack.push(temp);
            if(temp.right != null)
                q.add(temp.right);
            if(temp.left != null)
                q.add(temp.left);
        }

        while (!stack.isEmpty())
            System.out.print(stack.pop().data+" ");
    }

    public static int height(Node root){
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static Node merge(Node t1,Node t2){
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        t1.data += t2.data;
        t1.left = merge(t1.left,t2.left);
        t1.right = merge(t1.right,t2.right);
        return t1;
    }

    public static void mirror(Node root){
        if (root == null)
            return;
        Node temp;
        if(root.left != null &&  root.right != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        mirror(root.left);
        mirror(root.right);
    }

    public static void leftView(Node root){
        boolean[] levels = new boolean[100];
        Arrays.fill(levels,false);
        leftView_util(root,levels,0);
    }
    private static void leftView_util(Node root,boolean[] levels,int currentLevel){
        if(root == null)
            return;

        if(!levels[currentLevel]){
            levels[currentLevel] = true;
            System.out.println(root.data);
        }

        leftView_util(root.left,levels,currentLevel+1);
        leftView_util(root.right,levels,currentLevel+1);
    }

    public static void rightView(Node root){
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int n;
        Node temp = null;

        while (!q.isEmpty()){
            n = q.size();
            for(int i = 1; i<=n; i++) {
                temp = q.poll();
                if (i == n)
                    System.out.print((temp != null ? temp.data + " " : ""));
                if (temp != null && temp.left != null)
                    q.add(temp.left);
                if (temp != null && temp.right != null)
                    q.add(temp.right);
            }
        }
    }

    public static boolean isSymmetric(Node root) {
        if(root == null)
            return true;
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(Node t1,Node t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.data == t2.data) && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }
    
    public static void topView(Node root){
        class QObj{
            final Node n;
            final int hd;
            public QObj(Node t, int x){
                n = t;
                hd = x;
            }
        }
        Map<Integer, Integer> map = new TreeMap<>(); // We can also use HashMap here but it will not give sorted output
        Queue<QObj> q = new LinkedList<>();

        if(root == null)
            return;
        q.add(new QObj(root,0));
        while (!q.isEmpty()){
            QObj temp = q.poll();

            // if key is already present don't add this will give us the top value
            if(!map.containsKey(temp.hd))
                map.put(temp.hd,temp.n.data);

            if(temp.n.left != null)
                q.add(new QObj(temp.n.left,temp.hd-1));
            if(temp.n.right != null)
                q.add(new QObj(temp.n.right,temp.hd+1));
        }
        map.forEach((dist, data) -> System.out.println(data));
    }

    public static void bottomView(Node root){
        class QObj{
            final Node n;
            final int hd;
            QObj(Node t, int x){
                n = t;
                hd = x;
            }
        }
        if (root == null)
            return;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<QObj> q = new LinkedList<>();

        q.add(new QObj(root,0));

        while (!q.isEmpty()) {
            QObj temp = q.poll();

            // Replace the value if key is already present this will give us the bottom most value
            map.put(temp.hd, temp.n.data);

            if (temp.n.left != null)
                q.add(new QObj(temp.n.left,temp.hd-1));

            if (temp.n.right != null)
                q.add(new QObj(temp.n.right,temp.hd+1));
        }
        map.forEach((dist, data) -> System.out.println(data));
    }
}
