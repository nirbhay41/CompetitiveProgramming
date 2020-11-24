package com.RocketScience.DSA.BinarySearch;

public class SortedArrayRotated {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{4,5,6,7,0,1,2}));
    }
    public static int minElement(int[] a){
        int N = a.length;
        if(a[0] < a[N-1])
            return 0;
        int low = 0,high = N-1,mid,prev,next;

        while (low <= high){
            if(a[low] <= a[high]) return a[low];
            mid = low + (high - low)/2;

            if(a[mid] >= a[high]) low = mid+1;
            else high = mid;
        }
        return a[low];
    }
}
