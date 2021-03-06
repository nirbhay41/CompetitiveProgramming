package com.RocketScience.DSA.BitMagic;

//https://graphics.stanford.edu/~seander/bithacks.html
public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(BrianAlgo(-3));
    }

    //Method - I : Simple Approach O(total no of bits)
    public static int Count(int n){
        int count = 0;

        while(n != 0){
            count += n&1;
            n >>= 1;
        }
        return count;
    }

    //Method - II : Brian Kernighan’s Algorithm O(set bits)
    public static int BrianAlgo(int n){
        int count = 0;
        while (n != 0){ // n > 0 will not work here because n can be in negative also
            n &= (n-1);
            count++;
        }
        return count;
    }

    //Method - III: Lookup Table O(1)
    public static class LookupTable{
        static int[] BitsSetTable256 = new int[256];

        // Function to initialise the lookup table
        public static void initialize() {
            // To initially generate the table algorithmically
            BitsSetTable256[0] = 0;
            for (int i = 0; i < 256; i++) {
                BitsSetTable256[i] = (i & 1) + BitsSetTable256[i / 2];
            }
        }

        // Function to return the count of set bits in n
        public static int countSetBits(int n) {
            return (BitsSetTable256[n & 0xff]
                    + BitsSetTable256[(n >> 8) & 0xff]
                    + BitsSetTable256[(n >> 16) & 0xff]
                    + BitsSetTable256[n >> 24]);
        }
    }
}
