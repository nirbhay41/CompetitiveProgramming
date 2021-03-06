package com.RocketScience.DSA.LinkedList;

public class ReverseLinkedList_in_groupOfGivenSize {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        head = iter_rev(head,4);
        display(head);
    }

    private static void display(Node head) {
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static Node recur_reverse(Node head, int k){
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

       /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (next != null)
            head.next = recur_reverse(next, k);

        // prev is now head of input list
        return prev;
    }

    public static Node iter_rev(Node head, int k){
        Node curr = head,prevFirst = null,next = null;
        boolean isFirst = true;
        while(curr != null){
            Node first = curr,prev = null;
            int count = 0;
            while(curr != null && count < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if(isFirst){
                head = prev;
                isFirst = false;
            }else prevFirst.next = prev;

            prevFirst = first;
        }

        return head;
    }
}
