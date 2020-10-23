package com.RocketScience.DSA.LinkedList;

public class addOne {
    public static void main(String[] args) {
        Node head = new Node(9);
        head = addOne(head);
        display(head);
    }

    public static void display(Node head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node addOne(Node head)
    {
        head = reverse(head);

        Node res = head,temp = null;
        int carry = 1 , sum = 0;
        while(head != null){
            sum = carry + head.data;
            carry = (sum >= 10) ? 1 : 0;
            sum %= 10;
            head.data = sum;
            temp = head;
            head = head.next;
        }

        if(carry > 0 && temp != null)
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
