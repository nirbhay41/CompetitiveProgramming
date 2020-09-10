package com.RocketScience.DSA.Sorting;

/*
The Time Complexity of this algorithm is O(n+m) where n and m is the size of the 2 arrays
It sorts in linear time.
It is good for small numbers.
 */

import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] a){
        countingSort(a);
    }
    private static void countingSort(int[] a){
        final int max = Arrays.stream(a).max().getAsInt();
        int[] count = new int[max+1];
        Arrays.fill(count,0);

        for (int k : a) count[k]++;

        for(int i = 0,j=0;i<max+1;){
            if(count[i] > 0){
                a[j++] = i;
                count[i]--;
            }else i++;
        }
    }
}
