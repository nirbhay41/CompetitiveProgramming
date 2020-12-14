package com.RocketScience.DSA.Array;

public class WaveSort {
    public static void main(String[] args) {
        int[] a = {1,3,4,7,5,6,2};
        convertToWave(a,a.length);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }

    public static void convertToWave(int a[], int n){
        for(int i = 1;i<n;i+=2){ // move to every alternative element
            if(a[i-1] < a[i]){  // check if it is smaller than its previous element
                swap(a,i,i-1);
            }
            if(a[i] > a[i+1] && i<= n-2)
                swap(a,i,i+1);
        }
    }

    public static void swap(int[] a,int i,int j){
        int temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
