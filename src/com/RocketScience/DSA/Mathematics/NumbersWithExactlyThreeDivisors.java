package com.RocketScience.DSA.Mathematics;

public class NumbersWithExactlyThreeDivisors {
    public static void main(String[] args) {
        System.out.println(exactly3Divisors(67));
    }
    public static int exactly3Divisors(int N)
    {
        double x;
        int count = 0;
        for(int i = 2;i<=N;i++){
            if(PrimeCheck.isPrime(i)){
                if(i*i <= N)
                    count++;
            }
        }
        return count;
    }
}
