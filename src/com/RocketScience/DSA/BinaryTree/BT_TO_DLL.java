package com.RocketScience.DSA.BinaryTree;

public class BT_TO_DLL {
    static Node prev;
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node list = convert2(root);

        while (list != null){
            System.out.println(list.data);
            list = list.right;
        }
    }
    
    //Method - I:
    public static Node convert1(Node root){
        if(root == null)
            return null;
        prev = null;
        fixPrevPtr(root);
        return fixNextPtr(root);
    }

    private static Node fixNextPtr(Node root) {
        while (root.right != null){
            root = root.right;
        }

        while (root.left != null){
            Node left = root.left;
            left.right = root;
            root = root.left;
        }
        return root;
    }

    private static void fixPrevPtr(Node root) {
        if(root == null)
            return;
        fixPrevPtr(root.left);
        root.left = prev;
        prev = root;
        fixPrevPtr(root.right);
    }
    
    //Method - II:
    public static Node convert2(Node root){
        if(root == null)
            return null;

        Node head = convert2(root.left);
        if(prev == null)
            head = root;
        else{
            root.left = prev;
            prev.right = root;
        }

        prev = root;
        convert2(root.right);
        return head;
    }
}
