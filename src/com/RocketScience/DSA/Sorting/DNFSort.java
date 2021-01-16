package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

public class DNFSort {
    public static void main(String[] args) {
        int[] a = {10,5,6,3,20,9,40};
        sort(a,5,10);
        System.out.println(Arrays.toString(a));
    }

    //Segregate Three Types of elements in an array
    public static void sort(int[] a,int l,int r){
        int lo = 0,mid = 0,hi = a.length-1;

        while(mid <= hi){
            if(a[mid] < l){
                swap(a,lo,mid);
                lo++;
                mid++;
            }else if(l <= a[mid] && a[mid] <= r){
                mid++;
            }else {
                swap(a, mid, hi);
                hi--;
            }
        }
    }

    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
