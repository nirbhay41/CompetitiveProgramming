package com.RocketScience.DSA.BinarySearch;

public class SortedArrayRotated {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1}));
    }
    public static int minElement(int[] a){
        int N = a.length;
        if(a[0] < a[N-1])
            return 0;
        int low = 0,high = N-1,mid;

        while (low <= high){
            if(a[low] <= a[high]) return low;
            mid = low + (high - low)/2;

            if(a[mid] >= a[high]) low = mid+1;
            else high = mid;
        }
        return -1;
    }
}
