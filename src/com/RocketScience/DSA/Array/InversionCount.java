package com.RocketScience.DSA.Array;

import java.util.Scanner;

//Time Complexity: O(nlogn)
public class InversionCount {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] temp = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();

        System.out.println(mergeSort(a,temp,0,a.length-1));
    }

    public static int mergeSort(int[] a,int[] temp,int low,int high){
        int mid;
        int inversion_count = 0;
        if(low<high){
            mid = low + (high - low)/2;
            inversion_count += mergeSort(a,temp,low,mid);
            inversion_count += mergeSort(a,temp,mid+1,high);

            inversion_count += merge(a,temp,low,mid,high);
        }
        return inversion_count;
    }

    private static int merge(int[] a,int[] temp,int low, int mid, int high) {
        int i,j,k;
        int inversion_count = 0;

        i = low;
        j = mid+1;
        k = low;

        while(i<=mid && j<=high){
            if(a[i] <= a[j])
                temp[k++] = a[i++];
            else{
                temp[k++] = a[j++];
                inversion_count += (mid-i+1);
            }
        }

        while(i<= mid)
            temp[k++] = a[i++];
        while(j <= high)
            temp[k++] = a[j++];

        for(i = low;i<=high;i++)
            a[i] = temp[i];
        return inversion_count;
    }
}
