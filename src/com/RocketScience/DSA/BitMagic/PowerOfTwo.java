package com.RocketScience.DSA.BitMagic;

public class PowerOfTwo {
    public static void main(String[] args) {
    }

    //Check if a given number is a power of 2 or not
    //Method I: Naive Solution
    public static boolean isPower2(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;
    }

    //Method II: Use Brian Kernighan Algorithm to count no of set bits
    //We can use the fact that all numbers of power of 2 have only 1 bit set
    public static boolean method2(int n){
        return CountSetBits.BrianAlgo(n) == 1;
    }

    //Method III: Efficient Method
    public static boolean method3(int n){
        return n != 0 && (n&(n-1)) == 0;
        // we unset the right most set bit because numbers of power of 2 have only 1 bit set
    }
}
