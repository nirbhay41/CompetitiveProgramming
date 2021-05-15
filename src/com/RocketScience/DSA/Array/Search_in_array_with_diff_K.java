package com.RocketScience.DSA.Array;

//www.geeksforgeeks.org/searching-array-adjacent-differ-k/
public class Search_in_array_with_diff_K {
    public static void main(String[] args) {
        System.out.println(search(new int[]{20, 40, 50, 70, 60, 80}, 20, 60));
    }

    public static int search(int[] a,int k,int x){
        int i = 0;
        while (i<a.length){
            if(a[i] == x)
                return i;
            i = i + Math.max(1,Math.abs(a[i]-x)/k);
        }
        return -1;
    }
}
