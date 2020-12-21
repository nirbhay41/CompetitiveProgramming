package com.RocketScience.DSA.Array;

public class MaximumIndex {
    public static void main(String[] args) {
        System.out.println(maxIndex(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
    }

    public static int maxIndex(int[] a){
        int n = a.length;
        int[] lmin = new int[n];
        lmin[0] = a[0];

        for(int i = 1;i<n;i++){
            lmin[i] = Math.min(a[i],lmin[i-1]);
        }

        int[] rmax = new int[n];
        rmax[n-1] = a[n-1];

        for(int i = n-2;i>=0;i--){
            rmax[i] = Math.max(a[i],rmax[i+1]);
        }

        int i = 0,j=0,maxDiff = -1;

        while(i<n && j<n){
            if(lmin[i] <= rmax[j]){
                maxDiff = Math.max(maxDiff,j-i);
                j++;
            }else i++;
        }

        return maxDiff;
    }
}
