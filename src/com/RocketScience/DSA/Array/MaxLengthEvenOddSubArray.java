package com.RocketScience.DSA.Array;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        System.out.println(fun(new int[]{10, 13, 12, 17, 19, 21}));
    }

    //Kadene's Algorithm
    public static int fun(int[] a) {
        int length = 1, maxLength = 1;
        boolean evenOdd = true;
        for (int i = 1; i < a.length; i++) {
            if ((a[i] % 2 == 0 && a[i - 1] % 2 != 0) || (a[i] % 2 != 0 && a[i - 1] % 2 == 0)) {
                length++;
                maxLength = Math.max(maxLength,length);
            }else length = 1;
        }
        return maxLength;
    }
}
