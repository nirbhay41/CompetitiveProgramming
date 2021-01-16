package com.RocketScience.DSA.BinarySearch;

public class Find_an_Element_in_a_RotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(find(new int[]{10,20,40,60,5,8}, 60));
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

    public static int search(int[] a,int x){
        int low = 0,high = a.length-1,mid;

        while(low <= high){
            mid = low +(high-low)/2;

            if(a[mid] == x)
                return mid;

            if(a[low] < a[mid]){  // left half is sorted
                if(a[low] <= x && x <= a[mid-1]){ // check if x lies in this range
                    high = mid-1;
                }else low = mid+1;
            }else{  // right half is sorted
                if(a[mid+1] <= x && x <= a[high]){
                    low = mid+1;
                }else high = mid-1;
            }
        }
        return -1;
    }
}
