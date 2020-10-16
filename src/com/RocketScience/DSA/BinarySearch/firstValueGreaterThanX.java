package com.RocketScience.DSA.BinarySearch;

public class firstValueGreaterThanX {
    public static void main(String[] args) {
        System.out.println(find(new int[]{2, 3, 5, 6, 8, 12}, 4));
    }
    public static int find(int[] a,int x){
        int low = 0,high = a.length-1,mid,ans = -1;

        while (low <= high){
            mid = low + (high - low)/2;

            if(x < a[mid]) {
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans == -1 ? -1 : a[ans];
    }
}
