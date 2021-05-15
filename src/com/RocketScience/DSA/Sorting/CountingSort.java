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
    public static void countingSort(int[] a){
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

    //Time: O(n+k)  Space:O(n+k)
    public static void countSort(int[] a, int n, int k){
        int[] count=new int[k];
        for(int i=0;i<n;i++)
            count[a[i]]++; // count the freq

        for(int i=1;i<k;i++)
            count[i]=count[i-1]+count[i]; // count[i] tells how many elements are smaller or equal than i

        int[] output=new int[n];
        for(int i=n-1;i>=0;i--){ // we are running the loop from n-1 to 0 because of stability
            output[count[a[i]]-1]=a[i];
            count[a[i]]--;
        }
        for(int i=0;i<n;i++)
            a[i]=output[i];
    }
}
