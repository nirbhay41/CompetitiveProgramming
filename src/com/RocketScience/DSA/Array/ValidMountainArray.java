package com.RocketScience.DSA.Array;

//https://leetcode.com/problems/valid-mountain-array/
public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0, 2, 3, 4, 5, 2, 1, 0}));
    }

    public static boolean validMountainArray(int[] a) {
        if(a.length < 3)
            return false;

        //walk up
        int i = 0,n = a.length;
        while(i+1<n && a[i] < a[i+1])
            i++;

        if(i == 0 || i == n-1) // peak cannot be at start or end
            return false;

        //walk down
        while(i+1<n && a[i] > a[i+1])
            i++;

        return i == n-1;
    }
}
