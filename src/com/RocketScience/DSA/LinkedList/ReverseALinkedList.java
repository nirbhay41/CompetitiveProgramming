package com.RocketScience.DSA.LinkedList;

public class ReverseALinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = recur_reverse(head);
    }

    public static Node recur_reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node rest_head = recur_reverse(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    public static Node iter_reverse(Node head){
        Node r, q= null;
        Node curr = head;
        while(curr != null){
            r = q;
            q = curr;
            curr = curr.next;
            q.next = r;
        }
        return q;
    }
}
