package com.RocketScience.DSA.LinkedList;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class LinkedList {
    private Node head;
    public void append(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }
}
