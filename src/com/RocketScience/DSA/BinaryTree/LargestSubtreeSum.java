package com.RocketScience.DSA.BinaryTree;

//https://www.geeksforgeeks.org/find-largest-subtree-sum-tree/
public class LargestSubtreeSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);

        System.out.println(findLargestSubtreeSum(root));
    }

    static class INT {
        int v;
        INT(int a) {
            v = a;
        }
    }
    static int findLargestSubtreeSumUtil(Node root, INT ans){
        // If current node is null then  
        // return 0 to parent node.  
        if (root == null)
            return 0;

        // Subtree sum rooted  
        // at current node.  
        int currSum = root.data + findLargestSubtreeSumUtil(root.left, ans)
                                + findLargestSubtreeSumUtil(root.right, ans);

        // Update answer if current subtree  
        // sum is greater than answer so far.  
        ans.v = Math.max(ans.v, currSum);

        return currSum;
    }

    static int findLargestSubtreeSum(Node root) {
        if (root == null)
            return 0;

        INT ans = new INT(-9999999);
        findLargestSubtreeSumUtil(root, ans);

        return ans.v;
    }
}
