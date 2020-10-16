package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;

public class Find_Position_of_an_element_in_Infinitly_sorted_array {
    public static void main(String[] args) {

    }
    public static int search(int[] a,int x){ // Array is infinitely Sorted
        int low = 0,high=1;

        while(x > a[high]){
            low = high;
            high *= 2;
        }
        return Arrays.binarySearch(a,low,high,x);
    }
}
