package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

import java.util.Arrays;

public class N_Bonacci {
    public static void main(String[] args) {
        print(5,15);
    }

    //Time Complexity : O(M)
    public static void print(int n, int m){
        int[] a = new int[m];
        Arrays.fill(a,0);
        a[n-1] = 1;
        a[n] = 1;

        for(int i=n+1;i<m;i++)
            a[i] = 2*a[i-1] - a[i-n-1]; // (2*previous sum - first element in the sum)

        for(int i = 0;i<m;i++)
            System.out.print(a[i]+" ");
    }
}
