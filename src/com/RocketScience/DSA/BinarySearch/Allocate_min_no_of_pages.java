package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;

public class Allocate_min_no_of_pages {
    public static void main(String[] args) {
        System.out.println(minPages(new int[]{10, 20, 30, 40}, 2));
    }
    public static int minPages(int[] a,int k){
        int low = Arrays.stream(a).max().getAsInt();
        int high = Arrays.stream(a).sum();
        int mid,res=-1;

        while(low <= high){
            mid = low +(high-low)/2;

            if(isValid(a,k,mid)) {
                res = mid;
                high = mid-1;
            }else low = mid+1;
        }
        return res;
    }
    public static boolean isValid(int[] a,int k, int maxNoPages){
        int student = 1;
        int sum = 0;

        for(int i = 0;i<a.length;i++){
            sum += a[i];
            if(sum > maxNoPages){
                student++;
                sum = a[i];
            }
            if(student > k)
                return false;
        }
        return true;
    }
}
