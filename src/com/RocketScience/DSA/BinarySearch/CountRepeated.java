package com.RocketScience.DSA.BinarySearch;

public class CountRepeated {
    public static void main(String[] args) {
        int[] r = findRepeating(new Integer[]{2,3,4,5,5}, 5);
        System.out.println(r[0] +"   "+r[1]);
    }

    //Time:O(logn)  Find Repeating Element and its length
    public static int[] findRepeating(Integer[] a, int n) {
        int low = 0,high = n-1,mid,diff,rep = -1;

        while(low <= high){
            mid = low + (high-low)/2;
            diff = a[mid] - mid;

            if(a[mid].equals(a[mid + 1]) || a[mid - 1].equals(a[mid])){
                rep = a[mid];
                break;
            }

            if(diff != (a[low] - low))
                high = mid-1;
            else low = mid+1;
        }

        return new int[]{rep,n - (a[n-1] - a[0])}; // n - (a[n-1] - a[0]) (length of repeating sequence)
    }
}
