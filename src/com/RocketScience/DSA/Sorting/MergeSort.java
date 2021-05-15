package com.RocketScience.DSA.Sorting;

/*
The Time Complexity of merge sort is O(n log n)
It works on the principle of divide and conquer
 */

public class MergeSort {

    public static void sort(int[] a){
       final int l = 0,h = a.length-1;
       mergeSort(a,l,h);
    }

    private static void mergeSort(int[] a,int l,int h){
        if(l<h){
            int mid = l +(h-l)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,h);
            merge(a,l,mid,h);
        }
    }
    private static void merge(int[] A,int l,int mid,int h){
        int i,j,k;
        int[] B = new int[h+1];
        i = l;
        j=mid+1;
        k = l;
        while(i <= mid && j<= h){
            if(A[i] < A[j])
                B[k++] = A[i++];
            else
                B[k++] = A[j++];
        }
        for(;i<=mid;i++)
            B[k++] = A[i];
        for(;j<=h;j++)
            B[k++] = A[j];
        for(i = l;i<=h;i++)
            A[i] = B[i];
    }
}
