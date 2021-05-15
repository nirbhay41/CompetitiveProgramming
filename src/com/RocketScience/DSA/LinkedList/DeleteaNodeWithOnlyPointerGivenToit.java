package com.RocketScience.DSA.LinkedList;

public class DeleteaNodeWithOnlyPointerGivenToit {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        Node r = head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(25);

        deleteNode(r);
    }

    //Trick Interview Question
    private static void deleteNode(Node t) {
        t.data = t.next.data;
        t.next = t.next.next;
    }
}
