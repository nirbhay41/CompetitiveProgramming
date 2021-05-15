package com.RocketScience.DSA.LinkedList;

public class PairWiseSwap {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);


    }

    //Swapping the data
    public static void swap1(Node head){
        while(head != null && head.next != null){
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;
            head = head.next.next;
        }
    }

    //Changing the links
    public static Node swap2(Node head){
        if(head == null || head.next == null)
            return head;

        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;

        while(curr != null && curr.next != null){
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }

        prev.next = curr;
        return head;
    }
}
