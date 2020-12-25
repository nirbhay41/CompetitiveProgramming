package com.RocketScience.DSA.BitMagic;

public class TwoOddAppearing {
    public static void main(String[] args) {
        oddAppearing(new int[]{3,4,3,4,8,4,4,32,7,7});
    }

    public static void oddAppearing(int[] a){
        int XOR = 0,r1 = 0,r2 = 0;

        for(int i = 0;i<a.length;i++)
            XOR = XOR ^ a[i];

        int s = XOR & -XOR; // To get the rightmost set bit
        for(int i = 0;i<a.length;i++){
            if((a[i] & s) != 0)  // Divide the array into 2 groups one having s bit as set
                r1 ^= a[i];
            else r2 ^= a[i]; // One having that bit as unset
        }

        System.out.printf("%d   %d\n",r1,r2);
    }
}
