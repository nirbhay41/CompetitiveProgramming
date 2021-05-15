package com.RocketScience.DSA.Queue;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkedQueue {
    Node front,rear;

    public LinkedQueue(){
        front=rear=null;
    }
    public void enqueue(int x){
        Node t = new Node(x);
        if(isEmpty()) front = rear = t;
        else{
            rear.next = t;
            rear = t;
        }
    }
    public int dequeue(){
        int x = -1;
        if(isEmpty())
            throw new RuntimeException("Queue is Empty");
        else {
            x = front.data;
            front = front.next;
        }
        return x;
    }

    public boolean isEmpty(){
        return front == null;
    }
}
