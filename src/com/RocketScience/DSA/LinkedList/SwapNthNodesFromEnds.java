package com.RocketScience.DSA.LinkedList;

public class SwapNthNodesFromEnds {
    static DNode swapkthnode(DNode head, int len, int K)
    {
        if(K > len) return head;
        if(2*K-1 == len) return head;

        DNode x_prev = null;
        DNode x = head; // kth node from start

        DNode y_prev = null;
        DNode y = head; // kth node from end

        int count = K-1;
        while(count-- > 0){
            x_prev = x;
            x = x.next;
        }

        count = len - K;
        while(count-- > 0){
            y_prev = y;
            y = y.next;
        }

        if(x_prev != null)
            x_prev.next = y;
        if(y_prev != null)
            y_prev.next = x;

        DNode temp = x.next;
        x.next = y.next;
        y.next = temp;

        if(K == 1)
            head = y;
        if(K == len)
            head = x;
        return head;
    }
}
