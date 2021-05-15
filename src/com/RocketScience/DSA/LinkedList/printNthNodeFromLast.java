package com.RocketScience.DSA.LinkedList;


public class printNthNodeFromLast {
    public static void main(String[] args) {
       Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        Naive_printNthNodeLast(head,3);
        efficient_2_pointer(head,3);
    }

    public static void Naive_printNthNodeLast(Node head, int n){
        if(head == null)
            return;

        if(head.next == null && n > 1)
            return;

       Node ptr = head;
        int len = 0;
        while(ptr != null) {
            len++;
            ptr = ptr.next;
        }

        if(len < n)
            return;
        len = len - n;
        ptr = head;
        for(int i = 0;i<len;i++){
            ptr = ptr.next;
        }

        System.out.print(ptr.data);
    }

    public static void efficient_2_pointer(Node head, int n){
        if(head == null)
            return;
        Node slow = head,fast = head;

        while(n > 0){
            if(fast == null)  // if n > length of linked list
                return;
            fast = fast.next;
            n--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        System.out.print(slow.data);
    }
}
