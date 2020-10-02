package com.RocketScience.DSA.LinkedList;

import java.util.*;

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
    public Node oddEvenList(){ //Medium LeetCode Problem
        if (head == null) return null;
        Node odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

        //My Solution -- Working
/*        if(head == null){
            return null;
        }
        // For ODD
        ListNode odd = head,ptr1 = odd;
        head = head.next;
        odd.next = null;

        //FOR EVEN
        ListNode even = head,ptr2 = even;
        if(head != null)
            head = head.next;
        else return odd;
        even.next = null;
        byte flag = 0;

        while(head != null){
            if(flag == 0){
                ptr1.next = head;
                head = head.next;
                ptr1 = ptr1.next;
                ptr1.next = null;
                flag = 1;
            }else{
                ptr2.next = head;
                head = head.next;
                ptr2 = ptr2.next;
                ptr2.next = null;
                flag = 0;
            }
        }
        ptr1 = odd;
        while(ptr1.next != null){
            ptr1 = ptr1.next;
        }
        ptr1.next = even;
        return odd;*/
    }
    public int numComponents(int[] G) { //Medium Leetcode Problem
        Set<Integer> Gset = new HashSet<>();
        for (int x: G) Gset.add(x);

        Node cur = head;
        int ans = 0;

        while (cur != null) {
            if (Gset.contains(cur.data) &&
                    (cur.next == null || !Gset.contains(cur.next.data)))
                ans++;
            cur = cur.next;
        }
        return ans;

        /*My Solution -- Not Working
        if(head == null){
            return 0;
        }
        Node ptr1 = head,ptr2;
        if(head.next != null){
            ptr2 = head.next;
        }else return 1;
        int link = 0;

        while (ptr2 != null){
            Node finalPtr1 = ptr1;
            Node finalPtr2 = ptr2;
            if(Arrays.stream(G).anyMatch(x -> x == finalPtr1.data) && Arrays.stream(G).anyMatch(x -> x == finalPtr2.data)){
                link++;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if(ptr1 != null)
            link++;
        return link;*/
    }
    /*
    Input: [2,7,4,3,5]
    Output: [5,5,0]
     */
    public int[] nextLargerNodes() { // Medium LeetCode Problem --- Use Stack in this problem
        List<Integer> res = new ArrayList<>();
        Node parent = head,ptr;

        if(head.next == null){
            res.add(0);
            return res.stream().mapToInt(i -> i).toArray();
        }else ptr = head.next;

        while (parent != null){
            while(ptr != null && ptr.data <= parent.data){
                ptr = ptr.next;
            }
            if(ptr == null){
                res.add(0);
            }else res.add(ptr.data);
            parent = parent.next;
            if(parent != null)
                ptr = parent.next;
        }
        return res.stream().mapToInt(x -> x).toArray();
    }
    public Node middle(){ // We can do these with stack also
        Node slow,fast;
        slow=fast=head;

        while(fast != null){
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
            if(fast != null)
                slow = slow.next;
        }
        return slow;
    }
    /*
    We can find intersection of 2 linkedlist using stack also

    Node p = first
    while(p != null)
    {
       stack1.push(p)
       p = p.next;
    }

    p = first
    while(p != null)
    {
       stack2.push(p)
       p = p.next;
    }

    while(stack1.peek() == stack2.peek()){
       p = stack1.pop();
       stack2.pop();
    }
    return p;
     */
}
