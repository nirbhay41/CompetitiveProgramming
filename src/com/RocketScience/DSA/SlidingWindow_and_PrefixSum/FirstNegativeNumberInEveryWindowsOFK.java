package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowsOFK {
    public static void main(String[] args) {
        firstNegative(new int[]{-8, 2, 3, -6, 10},2);
    }

    public static void firstNegative(int[] a, int k){
        if(k > a.length)
            return;
        Queue<Integer> q = new LinkedList<>();
        int start = 0;

        for(int end = 0;end<a.length;){
            if(end - start + 1 <= k) {
                if (a[end] < 0)
                    q.add(a[end]);
                if(end - start+1 == k)
                    System.out.print(((q.size() != 0) ? q.peek() : 0)+" ");
                end++;
            }else{
                if(a[start] < 0){
                    q.poll();
                }
                start++;
            }
        }
    }
}
