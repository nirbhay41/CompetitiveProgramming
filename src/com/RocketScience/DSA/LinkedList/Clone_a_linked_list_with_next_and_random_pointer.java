package com.RocketScience.DSA.LinkedList;

class RNode{
    int data;
    RNode next,arb;
    public RNode(int x){
        data = x;
        arb = null;
        next = null;
    }
}

class Clone_a_linked_list_with_next_and_arb_pointer {

    public static void main(String[] args) {
        RNode start = new RNode(1);
        start.next = new RNode(2);
        start.next.next = new RNode(3);
        start.next.next.next = new RNode(4);
        start.next.next.next.next = new RNode(5);

        // 1's arb points to 3  
        start.arb = start.next.next;

        // 2's arb points to 1  
        start.next.arb = start;

        // 3's and 4's arb points to 5  
        start.next.next.arb = start.next.next.next.next;
        start.next.next.next.arb = start.next.next.next.next;

        // 5's arb points to 2  
        start.next.next.next.next.arb = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        RNode cloned_list = copyList(start);
        print(cloned_list);
    }
    //-------------------------------------------------------------------------------

    static RNode copyList(RNode head) {
        RNode curr = head,temp;

        while (curr != null){
            temp = curr.next;
            curr.next = new RNode(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        while (curr != null){
            if(curr.next != null){
                curr.next.arb = (curr.arb != null) ? curr.arb.next : null;
            }
            curr = (curr.next != null) ? curr.next.next : null;
        }

        RNode original = head,copy = head.next;
        temp = copy;
        while (original != null && copy != null){
            original.next = (original.next != null) ? original.next.next : null;

            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
    //--------------------------------------------------------------------------------------

    static void print(RNode start)
    {
        RNode ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.data +
                    ", Random = "+ptr.arb.data);
            ptr = ptr.next;
        }
    }
}
