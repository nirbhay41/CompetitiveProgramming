package com.RocketScience.DSA.BitMagic;

public class MaxAND {
    public static void main(String[] args) {
        System.out.println(maxAND(new int[]{4, 8, 12,10, 16}));
    }

    static int checkBit(int pattern, int[] a, int n){
        int count = 0;
        for (int i = 0; i < n; i++)
            if ((pattern & a[i]) == pattern)
                count++;
        return count;
    }

    //Time Complexity : O(n * log(m)) where m is the maximum element from the array and n is the size of the array.
    static int maxAND (int[] a){
        int n = a.length;
        int res = 0, count;

        // iterate over total of 30bits from msb to lsb
        for (int bit = 31; bit >= 0; bit--) {
            // find the count of element having that bit as set
            count = checkBit(res | (1 << bit), a, n);

            //if count >= 2 set particular bit in result
            if ( count >= 2 )
                res |= (1 << bit);
        }

        return res;
    }
}
