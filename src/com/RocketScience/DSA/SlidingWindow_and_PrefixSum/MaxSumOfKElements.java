package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class MaxSumOfKElements {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1, 8, 30, -5, 20, 7}, 3));
    }

    //Sliding Window Technique
    //Time Complexity: O(K+N-K) = O(N)
    public static int maxSum(int[] a,int k){
        int max_sum,curr_sum = 0;
        for(int i = 0;i<k;i++)   // O(K)
            curr_sum += a[i];

        max_sum = curr_sum;
        for(int i = k;i<a.length;i++){      // O(N-K)
            curr_sum += (a[i] - a[i-k]);
            max_sum = Math.max(max_sum,curr_sum);
        }
        return max_sum;
    }
}
