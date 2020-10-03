package com.RocketScience.DSA.Stack;

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    public static Node TOP;
    public static void main(String[] args) {
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);

        display();
        System.out.println(pop());
        System.out.println(peek(2));
    }
    public static void push(int data){
        Node t = new Node(data);
        if(t == null){ // If we are unable to create more node on heap then stack is full
            System.out.println("STACK OVERFLOW!!!");
        }else{
            t.next = TOP;
            TOP = t;
        }
    }
    public static int pop(){
        int x = -1;
        Node p;
        if(TOP == null){
            System.out.println("STACK is Empty!!!");
        }else{
            p = TOP;
            TOP = TOP.next;
            x = p.data;
            p.next = null;
        }
        return x;
    }
    public static int peek(int pos){
        Node p = TOP;
        for(int i = 0;p!=null && i<pos-1;i++){
            p = p.next;
        }
        if(p != null)
            return p.data;
        else return -1;
    }
    public static int stackTop(){
        if(TOP != null){
            return TOP.data;
        }
        return -1;
    }
    public static boolean isEmpty(){
        return TOP == null;
    }
    public static void display(){
        Node p = TOP;
        while (p != null){
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
    }
}
