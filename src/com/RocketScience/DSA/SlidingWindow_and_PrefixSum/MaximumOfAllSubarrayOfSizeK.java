package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        maxofallsubarray(new int[]{1,3,-1,-3,5,3,6,7},3);
    }

    public static void maxofallsubarray(int[] a, int k){
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0;i<k;i++){
            while (!dq.isEmpty() && a[i] > dq.peekLast()) // if a smaller number is present then remove it
                dq.removeLast();
            dq.addLast(a[i]);
        }

        for(int i = k;i<a.length;i++){
            System.out.print(dq.peek()+" ");
            while(!dq.isEmpty() && a[i] > dq.peekLast())
                dq.removeLast();
            dq.addLast(a[i]);
        }
        System.out.print(dq.peek());
    }
}
