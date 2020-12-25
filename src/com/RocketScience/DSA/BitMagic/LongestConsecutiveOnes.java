package com.RocketScience.DSA.BitMagic;

public class LongestConsecutiveOnes {
    public static void main(String[] args) {
    }

    //Time: O(length of longest Consecutive 1's)
    public static int maxConsecutiveOnes(int n){
        int ans = 0;
        while(n > 0){
            n = n&(n<<1); // removing each trailing 1 in every sequence
            ans++;
        }

        return ans;
    }
}
