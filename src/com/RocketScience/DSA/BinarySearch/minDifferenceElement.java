package com.RocketScience.DSA.BinarySearch;

public class minDifferenceElement {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1, 3, 8, 10, 15}, 12));
    }
    public static int minDifference(int[] a,int key){ // Absolute Difference
        int low = 0,high = a.length-1,mid;

        while(low <= high){
            mid = low + (high-low)/2;

            if(a[mid] == key) return key;
            else if(key < a[mid]) high = mid-1;
            else low = mid+1;
        }
        int x = Math.abs(a[low] - key);
        int y = Math.abs(a[high] - key);

        return (x > y) ? a[high] : a[low];
    }
}
