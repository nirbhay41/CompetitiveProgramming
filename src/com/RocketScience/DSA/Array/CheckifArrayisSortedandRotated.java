package com.RocketScience.DSA.Array;

public class CheckifArrayisSortedandRotated {
    public static void main(String[] args) {
        System.out.println(checkRotatedAndSorted(new int[]{20, 30, 10, 50, 35}, 5));
    }

    //Time Complexity: O(N)   Space:O(1)
    static boolean checkRotatedAndSorted(int[] a, int n){
        return II (a, n) || DD (a, n);
    }

    static boolean II(int[] a, int n) {  // Increasing
        int i = 0;
        while (i < n - 1 && a[i] <= a[i + 1]) i++;
        if (i == n - 1) return false; // if already sorted

        i++;
        while (i < n - 1 && a[i] <= a[i + 1]) i++;

        return i == n - 1 && a[n - 1] <= a[0]; // checking for sorted array is increasing
    }

    static boolean DD (int[] a, int n) { // Decreasing
        int i = 0;
        while (i < n - 1 && a[i] >= a[i + 1]) i++; // elements increasing before min element
        if (i == n - 1) return false; // if already sorted

        i++;
        while (i < n - 1 && a[i] >= a[i + 1]) i++; // elements increasing after min element

        return i == n - 1 && a[n - 1] >= a[0]; // checking for sorted array is decreasing
    }
}
