package com.RocketScience.DSA.Sorting;

public class SelectionSort {
    public static void sort(int[] a){
        SelectionSort.selectionSort(a);
    }

    private static void selectionSort(int[] a) {
        int n = a.length;
        int temp,i,j,k;
        for(i = 0;i<n-1;i++){
            for(j = k = i; j<n ;j++){
                if(a[j] < a[k])
                    k = j;
            }
            temp = a[k];
            a[k] = a[i];
            a[i] = temp;
        }

    }
}
