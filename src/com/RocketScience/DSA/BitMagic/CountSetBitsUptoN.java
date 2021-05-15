package com.RocketScience.DSA.BitMagic;

public class CountSetBitsUptoN {
    public static void main(String[] args) {
        System.out.println(countSetBits(8));
    }

    public static int countSetBits(int n){
        n++; // Ignore 0
        int powerOf2 = 2;
        int count = n/2; // get the 2^0's bits in the first column

        while(powerOf2 <= n){
            int totalPairs = n/powerOf2; // total pair of 0's and 1's

            count += (totalPairs/2)*powerOf2; // get all 1's pair and get all 1 from it
            count += (totalPairs%2 == 1) ? (n %powerOf2) : 0;
            // If the count of pairs was odd then
            // add the remaining 1s which could
            // not be grouped together

            powerOf2 <<= 1; // next power of 2
        }

        return count;
    }
}
