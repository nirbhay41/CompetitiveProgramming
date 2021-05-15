package com.RocketScience.DSA.Array;

public class RainWaterTrapping {
    public static void main(String[] args) {
        System.out.println(getWater2(new int[]{3, 1, 0, 2, 1, 3}));
    }
    //Method-I: O(N^2) Naive Solution
    public static int getWater1(int[] a){
        int res = 0;
        for(int i = 1;i<a.length-1;i++){
            int lmax = a[i];
            for(int j = 0;j<i;j++)
                lmax = Math.max(lmax,a[j]);
            int rmax = a[i];
            for(int j = i+1;j<a.length;j++)
                rmax = Math.max(rmax,a[j]);
            res += Math.min(lmax,rmax) - a[i];
        }
        return res;
    }

    //Method-II : Efficient Solution O(N) and O(N) space
    public static int getWater2(int[] a){
        int res = 0;

        int n = a.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = a[0];
        for(int i = 1; i< n; i++)
            lmax[i] = Math.max(a[i],lmax[i-1]);

        rmax[n -1] = a[n -1];
        for(int i = n-2;i>=0;i--)
            rmax[i] = Math.max(a[i],rmax[i+1]);

        for(int i = 0;i<n;i++)
            res += Math.min(lmax[i],rmax[i]) - a[i];

        return res;
    }
}
