package com.RocketScience.week4.Assignment;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0;i<n;i++)
            a[i] = sc.nextInt();
        int k = sc.nextInt();
        int[] b = new int[k];
        for(int i = 0;i<k;i++){
            b[i] = sc.nextInt();
        }
        for(int i = 0;i<k;i++){
            System.out.print(binarySearch(a,b[i])+ " ");
        }
    }
    private static int binarySearch(int[] a,int key){
        int low = 0,high = a.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(key < a[mid]) high = mid - 1;
            else if(a[mid] < key) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
