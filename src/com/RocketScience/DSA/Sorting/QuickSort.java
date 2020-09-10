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

    private static void quickSort(int[] a,int l,int h){
        if(l >= h) return;
        int splitPoint;
        splitPoint = partition(a,l,h);
        quickSort(a,l,splitPoint);
        quickSort(a,splitPoint+1,h);
    }

    /*private static int randomPivot(int[] a,int l,int h){
        Random r = new Random();
        int pivot = r.nextInt(h-l) + l;
        int temp = a[l];
        a[l] = a[pivot];
        a[pivot] = temp;
        return partition(a,l,h);
    }*/
    public static int partition(int[] a, int low, int high)
    {
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
