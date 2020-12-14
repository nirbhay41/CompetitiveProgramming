package com.RocketScience.DSA.Mathematics;

import java.util.Arrays;

public class SieveofEratosthenes {
    public static void main(String[] args) {
        sieve(15);
    }
    //Time Complexity: O(nloglogn)
    public static void sieve(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);

        for(int i = 2;i<=n;i++){
            if(isPrime[i]){
                System.out.print(i+" ");
                for(int j = i*i;j<=n;j+=i)
                    isPrime[j] = false;
            }
        }
    }
}
