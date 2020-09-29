package com.RocketScience.DSA.LinkedList;

import java.util.Arrays;

public class LinkedList{
    private Node head;
    public LinkedList(){
        head = null;
    }
    public LinkedList(int data){
        head = new Node(data);
    }
    public void create(int[] a){
        Arrays.stream(a).forEach(this::append);
    }
    public void append(int data){
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }
    public void insert(int pos,int data){
        if(pos < 0 || pos > length())
            return;
        if(pos == 0){
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }
        else {
            Node curr = head;
            int i = 0;
            while (curr != null && i<pos-1) {
                curr = curr.next;
                i++;
            }
            if(curr != null){
                Node temp = new Node(data);
                temp.next = curr.next;
                curr.next = temp;
            }
        }
    }
    public void insertInSortedList(int data){
        Node temp = new Node(data);
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.data < data){
            prev = curr;
            curr = curr.next;
        }
        if(curr == head){
            temp.next = head.next;
            head = temp;
        }else{
            temp.next = prev.next;
            prev.next = temp;
        }
    }
    public void delete(int data){
        if(head == null) return;
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public void display(){
        if(head == null) return;
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }
    /*
        After we found the node containing that data we just simply move that node to starting
        So next time we get it in constant time.
     */
    public Node search(int data){
        Node prev = head;
        Node curr = head;
        while(curr != null){
            if(curr.data == data){
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }
    public int length(){
        if(head == null)
            return 0;
        Node curr = head;
        int l = 0;
        while (curr != null){
            l++;
            curr = curr.next;
        }
        return l;
    }
    public void removeDuplicates(){
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (prev.data == curr.data) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }
    //Uses Sliding pointers technique
    public void reverse(){
        Node r, q= null;
        Node curr = head;
        while(curr != null){
            r = q;
            q = curr;
            curr = curr.next;
            q.next = r;
        }
        head = q;
    }
    public void concat(LinkedList list){
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = list.head;
        list.head = null;
    }
    public static void merge(LinkedList list1,LinkedList list2){
        Node last,first = list1.head,second = list2.head;
        if(first.data < second.data){
            last = first;
            first = first.next;
        }else{
            last = second;
            second = second.next;
        }
        last.next = null;

        while (first != null && second != null){
            if(first.data < second.data){
                last.next = first;
                last = first;
                first = first.next;
            }else{
                last.next = second;
                last = second;
                second = second.next;
            }
            last.next = null;
        }
        if(first != null){
            last.next = first;
        }else last.next = second;
    }
    public void isLOOP(){   //Using Floyd’s Cycle-Finding Algorithm
        Node fast = head,slow = head;
        boolean flag = false;
        while (fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if(flag)
            System.out.println("LOOP FOUND!!!");
        else
            System.out.println("LOOP NOT FOUND!!!");
    }
    public boolean isPalindrome(){
        Node fast = head,slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseP(slow);
        fast = head;

        while(slow != null){
            if(slow.data != fast.data){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private Node reverseP(Node head){
        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
