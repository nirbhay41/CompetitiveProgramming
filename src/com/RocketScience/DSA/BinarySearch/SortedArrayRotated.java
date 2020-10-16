package com.RocketScience.DSA.BinarySearch;

public class SortedArrayRotated {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{11,12,15,18,2,5,6,8}));
    }
    public static int minElement(int[] a){
        int N = a.length;
        if(a[0] < a[N-1])
            return 0;
        int low = 0,high = N-1,mid,prev,next;

        while (low <= high){
            if(a[low] <= a[high])
                return low;

            mid = low + (high - low)/2;
            next = (mid + 1) % N;
            prev = (mid + N - 1) % N;

            if(a[mid] <= a[prev] && a[mid] <= a[next]) // to check if mid is a min element
                return mid;
            if(a[low] <= a[mid]) // if this is sorted move low to other half
                low = mid+1;
            else if(a[mid] <= a[high]) // if this is sorted move high to other half
                high = mid - 1;
        }
        return -1;
    }
}
