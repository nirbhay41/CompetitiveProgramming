package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

//Leetcode Easy
public class SortByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    // Sort such that whenever A[i] is odd then i is odd  and  A[i] is even i is even
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) { // if A[i] is odd on even index
                while (A[j] % 2 == 1) // Search on odd index where A[i] is even
                    j += 2;

                //Swap those 2 values
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        return A;
    }
}
