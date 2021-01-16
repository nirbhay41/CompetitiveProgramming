package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] a = {1,5,2,9,4,10};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        for(int cs = 0;cs < a.length-1;cs++){ // for cycles
            int item = a[cs];
            int pos = cs;

            for(int i = cs+1;i<a.length;i++){ // fix the first item
                if(a[i] < item) // no of items smaller than a[i] on the right of it
                    pos++;
            }

            int temp = a[pos];
            a[pos] = item;
            item = temp;

            while(pos != cs){
                pos = cs;
                for(int i = cs+1;i<a.length;i++){ // fix the remaining item
                    if(a[i] < item)
                        pos++;
                }
                //for counting min no of swaps required to sort an array just add res++ here
                temp = a[pos];
                a[pos] = item;
                item = temp;
            }
        }
    }
}
