package com.RocketScience.DSA.BitMagic;

public class SwapEvenandOddBits {
    public static void main(String[] args) {

    }

    public static int swap(int n){
        int evenBits = n&0xAAAAAAAA; // extract all even bits
        int oddBits = n&0x55555555;  // extract all odd bits

        evenBits >>= 1; // move even bits to right
        oddBits <<= 1;  // move odd bits to left

        return (evenBits | oddBits);
    }
}
