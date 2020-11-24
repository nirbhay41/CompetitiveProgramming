package com.RocketScience.DSA.Array_ADT;

//https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(divideandconq(new int[]{3,3,4}));
        System.out.println(boyerMoore(new int[]{3,3,4}));
    }

    //Method - I : Divide and Conquer O(nlogn)
    public static int divideandconq(int[] a){
        return solve(a,0,a.length-1);
    }

    public static int solve(int[] a,int low,int high){
        if(low == high)
            return a[low];

        int mid = low + (high-low)/2;
        int lme = solve(a,low,mid);
        int rme = solve(a,mid+1,high);

        if(lme == rme) return lme;

        int leftCount = count(a,lme,low,high);
        int rightCount = count(a,rme,low,high);
        return leftCount > rightCount ? lme : rme;
    }

    private static int count(int[] a, int x, int low, int high) {
        int res = 0;
        for(int i = low;i<=high;i++){
            if(a[i] == x)
                res++;
        }
        return res;
    }

    //Method - II : Boyer-Moore Voting Algorithm O(n)
    public static int boyerMoore(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
