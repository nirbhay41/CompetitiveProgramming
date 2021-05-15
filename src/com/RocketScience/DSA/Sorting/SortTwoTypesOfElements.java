package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

public class SortTwoTypesOfElements {
    public static void main(String[] args) {
        int[] a = {2,4,9,6,3,1,5,8};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    //Using Hoare's Partition for segregating even no on one side and odd no on other side
    //Time: O(n)
    public static void sort(int[] a){
        int i = -1,j = a.length;

        while(true){
            do{ i++; }while(a[i]%2 == 0);
            do{ j--; }while(a[j]%2 != 0);

            if(i >= j)
                break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
