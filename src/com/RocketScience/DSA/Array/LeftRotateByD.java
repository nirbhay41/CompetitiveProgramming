package com.RocketScience.DSA.Array;

public class LeftRotateByD {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        leftRotate2(a,2);
    }

    //Method - I: O(n) & Space : O(d)
    public static void leftRotate1(int[] a,int d){
        int[] temp = new int[d];
        int i;
        for(i = 0;i<d;i++)
            temp[i] = a[i];
        for(i = d;i<a.length;i++)
            a[i-d] = a[i];
        for(i = 0;i<d;i++)
            a[a.length-d+i] = temp[i];
    }

    //Method II: O(n) & Space: O(1)
    public static void leftRotate2(int[] a,int d){
        int n = a.length;
        reverse(a,0,d-1);
        reverse(a,d,n-1);
        reverse(a,0,n-1);
    }

    public static void reverse(int[] a,int low,int high){
        while(low < high){
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }
}
