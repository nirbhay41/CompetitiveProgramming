package com.RocketScience.DSA.BinarySearch;

public class FirstandLastOccurence {
    public static void main(String[] args) {
        System.out.println(lastOccurence(new int[]{2,4,10,10,10,18,20}, 10));
    }
    public static int firstOccurence(int[] a,int x){
        int low = 0,high = a.length-1,mid,res=-1;
        while (low <= high){
            mid = low + (high-low)/2;

            if(a[mid] == x) {
                res = mid;
                high = mid - 1;   // We continue our search in the left part
            } else if(x < a[mid]) high = mid - 1;
            else low = mid+1;
        }
        return res;
    }
    public static int lastOccurence(int[] a,int x){
        int low = 0,high = a.length-1,mid,res=-1;
        while (low <= high){
            mid = low + (high-low)/2;

            if(a[mid] == x) {
                res = mid;
                low = mid + 1;  // We continue our search in the right part
            } else if(x < a[mid]) high = mid - 1;
            else low = mid+1;
        }
        return res;
    }
}
