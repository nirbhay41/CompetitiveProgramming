package com.RocketScience.DSA.BinaryTree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class FindLCAinBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + findLCA1(root,4,5));
        path1.clear();
        path2.clear();
        System.out.println("LCA(4, 6): " + findLCA2(root,4,6).data);
        path1.clear();
        path2.clear();
        System.out.println("LCA(3, 4): " + findLCA2(root,3,4).data);
        path1.clear();
        path2.clear();
        System.out.println("LCA(2, 4): " + findLCA1(root,2,4));
    }

    //Method - I : O(n) -  The tree is traversed twice, and then path arrays are compared.
    private static final List<Integer> path1 = new ArrayList<>();
    private static final List<Integer> path2 = new ArrayList<>();

    private static int findLCA1(Node root, int n1, int n2) {

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            //System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    private static boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (findPath(root.left, n, path)) {
            return true;
        }

        if (findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size()-1);

        return false;
    }
//---------------------------------------------------------------------------------------------
    //Method - II : O(n) - But only single traversal
    public static Node findLCA2(Node root, int n1, int n2) {
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.data == n1 || root.data == n2)
            return root;

        // Look for keys in left and right subtrees
        Node left_lca = findLCA2(root.left, n1, n2);
        Node right_lca = findLCA2(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this root is the LCA
        if (left_lca!=null && right_lca!=null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
}
