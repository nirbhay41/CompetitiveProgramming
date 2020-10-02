package com.RocketScience.DSA.LinkedList;

class DoublyNode{
    DoublyNode prev;
    int data;
    DoublyNode next;

    public DoublyNode(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class DoublyLinkedList {
    public static DoublyNode Head = null;
    public static void main(String[] args) {
        create(new int[]{1,2,3,4,5,6});
        display(Head);
        reverse(Head);
        display(Head);
    }
    public static void create(int[] a){
        DoublyNode temp,last;
        Head = new DoublyNode(a[0]);
        Head.prev = Head.next = null;
        last = Head;

        for(int i = 1;i<a.length;i++){
            temp = new DoublyNode(a[i]);
            temp.next = null;
            temp.prev = last;
            last.next = temp;
            last = temp;
        }
    }
    public static void display(DoublyNode head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
        System.out.println();
    }
    public static int length(DoublyNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    public static void insert(DoublyNode head,int pos,int data){
        if(pos < 0 || pos >length(head))
            return;
        DoublyNode temp = new DoublyNode(data);
        if(pos == 0){
            if(Head == null){
                Head = new DoublyNode(data);
                Head.prev = Head.next = null;
            }else{
                temp.next = Head;
                temp.prev = null;
                Head.prev = temp;
                Head = temp;
            }
        }else{
            for(int i = 0;i<pos-1;i++){
                head = head.next;
            }
            temp.next = head.next;
            temp.prev = head;
            if(head.next != null) {
                head.next.prev = temp;
            }
            head.next = temp;
        }
    }
    public static void delete(DoublyNode head,int pos){
        if(pos < 1 || pos > length(Head))
            return;
        if(pos == 1){
            Head = Head.next;
            if(Head != null)
                Head.prev = null;
        }else{
            for(int i = 0;i<pos-1;i++)
                head = head.next;
            head.prev.next = head.next;
            if(head.next != null)
                head.next.prev = head.prev;
        }
    }
    public static DoublyNode insertInSorted(DoublyNode head,int data){
        if(head == null){
            head = new DoublyNode(data);
            head.next = null;
            head.prev = null;
            return head;
        }
        DoublyNode ptr = head;
        DoublyNode temp = new DoublyNode(data);

        if(data <= head.data){
            temp.next = head;
            temp.prev = null;
            head.prev = temp;
            head = temp;
            return head;
        }
        while(ptr.next != null && ptr.next.data < data){
            ptr = ptr.next;
        }
        if(ptr.next == null){
            temp.next = null;
            ptr.next = temp;
            temp.prev = ptr;
        }else{
            temp.next = ptr.next;
            temp.prev = ptr;
            ptr.next = temp;
            temp.next.prev = temp;
        }
        return head;
    }
    public static void reverse(DoublyNode head){
        DoublyNode temp;
        while(head != null){
            temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            head = head.prev;
            if(head != null && head.next == null){
                Head = head;
            }
        }
    }
}
