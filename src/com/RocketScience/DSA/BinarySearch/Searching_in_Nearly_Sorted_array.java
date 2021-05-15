package com.RocketScience.DSA.BinarySearch;

public class Searching_in_Nearly_Sorted_array {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 6, 17, 30, 20, 40}, 5));
    }
    public static int search(int[] a,int x){
        int low = 0,high=a.length-1,mid;

        while(low<=high){
            mid = low + (high-low)/2;

            if(x == a[mid]) return mid;
            if(mid-1 >= low && a[mid-1] == x) return mid-1;
            if(mid+1<= high && a[mid+1] == x) return mid+1;

            if(x < a[mid]) high = mid-2;
            else low = mid+2;
        }
        return -1;
    }
}
