package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;

public class Search_in_a_Row_and_Column_wise_Sorted_Array {
    public static void main(String[] args) {
        int[] a = search(new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,45},
                {32,33,39,50}},27);
        if(a != null)
            Arrays.stream(a).forEach(System.out::println);
    }
    public static int[] search(int[][] a,int key){ // O(n+m)
        int n = a.length;
        int m = a[0].length;
        int i = 0,j=n-1;

        while(i >=0 && i < n && j >=0 && j < m){
            if(a[i][j] == key)
                return new int[]{i,j};
            else if(a[i][j] > key)
                j--;
            else i++;
        }
        return null;
    }
}
