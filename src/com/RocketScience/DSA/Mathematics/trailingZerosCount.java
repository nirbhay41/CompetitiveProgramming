package com.RocketScience.DSA.Mathematics;

public class trailingZerosCount {
    public static void main(String[] args) {
        System.out.println(trailingZeroCount(100));
    }
    //Time Complexity: O(log5(N))
    public static int trailingZeroCount(int n){
        int count = 0;
        for(int i = 5;i <= n;i*=5){
            count += n/i;
        }
        return count;
    }
}
