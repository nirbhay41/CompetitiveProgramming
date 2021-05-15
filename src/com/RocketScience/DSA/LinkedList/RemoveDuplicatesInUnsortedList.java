package com.RocketScience.DSA.LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesInUnsortedList {
    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        start = removeDuplicates(start);
        display(start);
    }

    public static void display(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node removeDuplicates(Node head){
        HashSet<Integer> set = new HashSet<>();

        Node curr = head;
        Node prev = null;

        while(curr != null){
            int currVal = curr.data;

            if(set.contains(currVal)){
                prev.next = curr.next;
            }else{
                set.add(currVal);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
