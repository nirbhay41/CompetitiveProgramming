package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;

public class Find_Position_of_an_element_in_Infinitly_sorted_array {
    public static void main(String[] args) {

    }

    //Time Complexity: O(log(pos))   where pos is element position
    public static int search(int[] a,int x){
        if(a[0] == x)
            return 0;
        
        int i = 1;

        while(x > a[i])
            i *= 2;

        if(a[i] == x)
            return i;

        return Arrays.binarySearch(a,i/2+1,i-1,x);
    }
}
