package com.RocketScience.DSA.BitMagic;

//https://www.hackerrank.com/challenges/maximizing-xor/problem
public class MaxXOR {
    public static void main(String[] args) {
        System.out.println(max(11, 100));
    }

    public static int max(int L,int R){
        int xor = L^R;
        int significantBit = 31 - Integer.numberOfLeadingZeros(xor);

        return (1 << (significantBit+1)) -1;
    }
}
