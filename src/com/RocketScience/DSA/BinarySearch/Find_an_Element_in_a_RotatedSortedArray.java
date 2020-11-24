package com.RocketScience.DSA.BinarySearch;

public class Find_an_Element_in_a_RotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(find(new int[]{3,1}, 0));
    }
    public static int find(int[] a,int x){
        int N = a.length;
        int low = 0,high=N-1,mid;
        int minIndex = SortedArrayRotated.minElement(a);

        if(a[minIndex] == x)
            return minIndex;

        if(x > a[N-1])
            high = minIndex-1;
        else low = minIndex+1;

        while (low<=high){
            mid = low + (high-low)/2;

            if(a[mid] == x) return mid;
            else if(x < a[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
