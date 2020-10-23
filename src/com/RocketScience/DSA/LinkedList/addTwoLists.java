package com.RocketScience.DSA.LinkedList;

public class addTwoLists {
    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(5);
        Node second = new Node(3);
        second.next = new Node(4);
        second.next.next = new Node(5);

        Node res = addLists(first,second);
        display(res);
    }

    public static void display(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static Node addLists(Node first, Node second){
        first = reverse(first);
        second = reverse(second);
        Node res = null,temp=null,prev = null;
        int sum = 0,carry = 0;
        while(first != null || second != null){
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum %= 10;
            temp = new Node(sum);

            if(res == null)
                res = temp;
            else prev.next = temp;

            prev = temp;

            if(first != null)
                first  = first.next;
            if(second != null)
                second = second.next;
        }
        if(carry > 0)
            temp.next = new Node(carry);
        return reverse(res);
    }

    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
