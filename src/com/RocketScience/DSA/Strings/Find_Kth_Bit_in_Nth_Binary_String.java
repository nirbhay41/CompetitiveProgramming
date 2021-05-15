package com.RocketScience.DSA.Strings;

//Leetcode Medium
public class Find_Kth_Bit_in_Nth_Binary_String {
    public static void main(String[] args) {
        System.out.println(findKthBit(4, 11));
    }

    public static char findKthBit(int n, int k) {
        int res = recur(0,(1<<n)-2,--k);
        return (res == 0) ? '0' : '1';
    }

    public static int recur(int low,int high,int k){
        if(low == high && low == 0) return 0;

        int mid = low + (high-low)/2;
        if(k == mid) return 1;
        if(k > mid)
            return recur(low,mid-1,high-k)^1; // find the bit in reverse order and then invert it
        else return recur(low,mid-1,k); // if k is in the left side then do nothing
    }
}
