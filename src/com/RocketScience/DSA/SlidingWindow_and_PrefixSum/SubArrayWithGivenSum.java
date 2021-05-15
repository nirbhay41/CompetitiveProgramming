package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subArraySum(new int[]{1, 4, 20, 3, 10, 5}, 10));
    }

    public static boolean subArraySum(int[] a,int targetSum){
        int n = a.length;
        int curr_sum = a[0],start = 0;

        for(int i = 1;i<=n;i++){
            //If current sum exceeds target sum then remove the starting elements
            while (curr_sum > targetSum && start < i-1){
                curr_sum -= a[start];
                start++;
            }
            if(curr_sum == targetSum)
                return true;

            if(i < n)
                curr_sum += a[i];
        }
        return curr_sum == targetSum;
    }
}
