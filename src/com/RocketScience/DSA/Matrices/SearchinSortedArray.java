package com.RocketScience.DSA.Matrices;

import java.util.Arrays;

public class SearchinSortedArray {
    public static void main(String[] args) {
        int[] a = search(new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,45},
                {32,33,39,50}},27);
        if(a != null)
            Arrays.stream(a).forEach(System.out::println);
    }
    public static int[] search(int[][] a,int key){ // O(r+c)
        int row = a.length;
        int column = a[0].length;
        int i = 0,j=row-1;

        while(i < row && j >=0){
            if(a[i][j] == key)
                return new int[]{i,j};
            else if(a[i][j] > key)
                j--;
            else i++;
        }
        return null;
    }
}
