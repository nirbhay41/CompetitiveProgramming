package com.RocketScience.DSA.Sorting;
/*
Its Time Complexity is O(n^2)
It is best suited for linked list because we don't have to do shifting of elements
 */
public class InsertionSort {
    public static void sort(int[] a){
        InsertionSort.insertionSort(a);
    }
    private static void insertionSort(int[] a){
        int n = a.length;
        for(int i = 1;i<n;i++){ //for passes
            int j = i-1;
            int x = a[i];
            while (j > -1 && a[j] > x){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = x;
        }
    }
}
