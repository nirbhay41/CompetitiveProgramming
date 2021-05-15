package com.RocketScience.DSA.Sorting;
/*
Time Complexity:
Best Case : O(n log n)
Average Case : O(n log n)
Worst Case : O(n^2)
 */

public class QuickSort {
    public static void sort(int[] a){
        quickSort(a,0,a.length-1);
    }

    //hoares partition is 3 times faster than lomuto Partition
    private static void quickSort(int[] a,int l,int h){
        if(l >= h) return;

        int splitPoint;
        splitPoint = lomutoPartition(a, l, h);
        quickSort(a, l, splitPoint-1); // for hoares Partition quickSort(a, l, splitPoint)
        quickSort(a, splitPoint + 1, h);
    }

    public static int lomutoPartition(int[] a,int low,int high){
        int pivot = a[high];
        int i = low-1;
        for(int j = low;j<high;j++){
            if(a[j] < pivot){
                i++;
                swap(a ,i,j);
            }
        }
        swap(a,i+1,high);
        return i+1;
    }

    public static int hoarePartition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i >= j)
                return j;
            swap(a, i, j);
        }
    }
    private static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
