package com.RocketScience.DSA.BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{0,1,5,9,10,11,14,1}));
    }
    public static int findPeak(int[] a){
        int low = 0,high = a.length-1,mid;

        while(low<=high){
            mid = low + (high-low)/2;

            if((mid == 0 || a[mid-1] <= a[mid]) && (mid == a.length-1 || a[mid] >= a[mid+1]))
                return mid;

            if(mid > 0 && a[mid-1] >= a[mid])
                high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
