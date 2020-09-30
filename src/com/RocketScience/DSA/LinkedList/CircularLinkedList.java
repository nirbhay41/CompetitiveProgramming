package com.RocketScience.DSA.LinkedList;

class CircularNode{
    int data;
    CircularNode next;
    public  CircularNode(int data){
        this.data = data;
    }
}

public class CircularLinkedList {
    public static CircularNode Head;
    public static void main(String[] args) {
        create(new int[]{1,2,34,5,63});
        //display(Head);
        insert(5,100);
        display(Head);
//        delete(Head,1);
//        display(Head);
    }
    public static void create(int[] a){
        CircularNode t,last;
        Head = new CircularNode(a[0]);
        Head.next = Head;
        last = Head;

        for(int i = 1;i<a.length;i++){
            t = new CircularNode(a[i]);
            t.next = last.next;
            last.next = t;
            last = t;
        }
    }
    public static void display(CircularNode head){
        do{
            System.out.println(head.data);
            head = head.next;
        }while (head != Head);
        System.out.println();
    }
    /*public static void R_display(CircularNode head){
        //static boolean flag = false;
        if(head != Head || !flag){
            flag = true;
            System.out.println(head.data);
            R_display(head.next);
        }
        flag = false;
    }*/
    public static void insert(int pos,int data){
        if(pos < 0 || pos > length(Head))
            return;
        CircularNode temp,ptr;
        temp = new CircularNode(data);
        if(pos == 0){
            if(Head == null){
                Head = temp;
                Head.next = Head;
            }else{
                ptr = Head;
                while (ptr.next != Head){
                    ptr = ptr.next;
                }
                ptr.next = temp;
                temp.next = Head;
                Head = temp;
            }
        }else{
            ptr = Head;
            for(int i = 0;i<pos-1;i++)
                ptr = ptr.next;
            temp.next = ptr.next;
            ptr.next = temp;
        }
    }
    public static void delete(CircularNode head,int pos){
        if(pos <= 0 || pos > length(Head))
            return;

        if(pos == 1){
            while(head.next != Head)
                head = head.next;
            if(head == Head){  // if this is the only node in the linkedlist
                Head = null;
            }else{
                head.next = Head.next;
                Head = head.next;
            }
        }else{
            for(int i = 0;i<pos-1;i++)
                head = head.next;
            head.next = head.next.next;
        }
    }

    public static int length(CircularNode head){
        int len = 0;
        if(head == null)
            return 0;
        do{
            len++;
            head = head.next;
        }while(head != Head);
        return len;
    }
}
