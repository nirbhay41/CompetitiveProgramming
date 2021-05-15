package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {22,54,98,1,2,5,3,84};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        int n = a.length;
        buildHeap(a); // build a max heap from the array

        for(int i = n-1;i>0;i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a,i,0);
        }
    }

    public static void buildHeap(int[] a){
        int n = a.length;
        for(int i = n/2-1;i>=0;i--){ // start from the last internal node
            heapify(a,n,i);
        }
    }

    private static void heapify(int[] a,int sizeOfHeap,int nodeIdx) {
        int largest = nodeIdx,left = 2*nodeIdx+1,right = 2*nodeIdx+2;

        if(left < sizeOfHeap && a[largest] < a[left])
            largest = left;
        if(right < sizeOfHeap && a[largest] < a[right])
            largest = right;

        if(largest != nodeIdx){
            int temp = a[nodeIdx];
            a[nodeIdx] = a[largest];
            a[largest] = temp;
            heapify(a,sizeOfHeap,largest);
        }
    }
}
