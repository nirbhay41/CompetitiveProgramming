package com.RocketScience.DSA.BinarySearch;

public class PeakElement {
    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{1,0,1,10,9,8,6,4,1}));
    }
    public static int findPeak(int[] a){
        int low = 0,high = a.length-1,mid,prev,next;

        while(low<high){
            mid = low + (high-low)/2;

            if(mid == 0 && a[mid] > a[mid+1])
                return a[mid];
            else if(mid == a.length-1 && a[mid] > a[a.length-2])
                return a[mid];
            else if(mid > 0 && mid < a.length-1) {
                if (a[mid - 1] <= a[mid] && a[mid] >= a[mid + 1])
                    return a[mid];
            }

            if(a[mid] <= a[mid+1])
                 low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
