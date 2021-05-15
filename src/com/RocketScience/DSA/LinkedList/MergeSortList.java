package com.RocketScience.DSA.LinkedList;

public class MergeSortList {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(8);
        head.next.next.next = new Node(2);

        head = mergeSort(head);
        display(head);
    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null)
            return head;
        Node middle = split(head);
        Node nextMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextMiddle);

        return merge(left,right);
    }
    public static Node merge(Node a, Node b){
        if(a == null)
            return b;
        if(b == null)
            return a;

        Node res;

        if(a.data <= b.data){
            res = a;
            res.next = merge(a.next,b);
        }else{
            res = b;
            res.next = merge(a,b.next); 
        }
        return res;
    }
    public static Node split(Node list){
        if(list == null)
            return null;

        Node fast = list,slow = list;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void display(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
