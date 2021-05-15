package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class Prefix_Sum {
    public static void main(String[] args) {
        System.out.println(getSum(new int[]{2, 8, 3, 9, 6, 5, 4}, 0, 3));
    }

    public static int getSum(int[] a,int l,int r){
        int[] prefix_sum = calculate_prefix_sum(a); // O(N) Time

        return l != 0 ? prefix_sum[r] - prefix_sum[l-1] : prefix_sum[r]; // O(1) Time
    }

    public static int[] calculate_prefix_sum(int[] a){
        int[] prefix_sum = new int[a.length];
        prefix_sum[0] = a[0];

        for(int i = 1;i<a.length;i++){
            prefix_sum[i] = prefix_sum[i-1] + a[i];
        }
        return prefix_sum;
    }
}
