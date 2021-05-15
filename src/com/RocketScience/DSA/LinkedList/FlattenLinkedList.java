package com.RocketScience.DSA.LinkedList;

/*
Input:
        5 -> 10 -> 19 -> 28
        |     |     |     |
        7     20    22   35
        |           |     |
        8          50    40
        |                 |
        30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
        22-> 28-> 30-> 35-> 40-> 45-> 50.
*/
class FNode{
    int data;
    FNode next;
    FNode bottom;

    FNode(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenLinkedList {
    FNode flatten(FNode root)
    {
        if(root == null || root.next == null)
            return root;

        return merge(root,flatten(root.next));
    }

    FNode merge(FNode a,FNode b){
        if(a == null)
            return b;
        else if(b == null)
            return a;

        FNode result;

        if(a.data < b.data){
            result = a;
            result.bottom = merge(a.bottom,b);
        }else{
            result = b;
            result.bottom = merge(a,b.bottom);
        }
        return result;
    }
}
