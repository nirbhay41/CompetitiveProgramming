package com.RocketScience.DSA.BinarySearch;

//https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1
public class SmallestFactorialNumber {
    public static void main(String[] args) {
        System.out.println(findNum(2));
    }

    //Time Complexity : O(log2 N * log5 N)  (log2 N for binary Search and log5 N for loop)
    static int findNum(int n) {
        if(n == 1)
            return 5;

        int low = 0,high = 5*n,mid;
        while(low < high){
            mid = low +((high-low) >> 1);

            if(check(mid,n))
                high = mid;
            else low = mid+1;
        }
        return low;
    }

    private static boolean check(int mid, int n) {
        int count = 0;
        for(int i = 5; mid/i >= 1 ;i *= 5){
            count += mid/i;
        }
        return count >= n;
    }
}
