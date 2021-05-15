package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class MaxAppearingElemetintheRange {
    public static void main(String[] args) {
        System.out.println(find(new int[]{1,5,9,13,21}, new int[]{15,8,12,20,30}));
    }

    //Very Tricky Solution and Important
    //Time: O(N)   Space: O(N)
    public static int find(int[] L,int[] R){
        int[] a = new int[1000];
        int n = L.length;

        for(int i = 0;i<n;i++){
            a[L[i]]++;
            a[R[i]+1]--;
        }

        int max = a[0],res = -1;
        for(int i = 1;i<1000;i++){
            a[i] += a[i-1];
            if(max < a[i]){
                max = a[i];
                res = i;
            }
        }
        return res;
    }
}
