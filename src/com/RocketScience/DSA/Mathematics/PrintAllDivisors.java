package com.RocketScience.DSA.Mathematics;

public class PrintAllDivisors {
    public static void main(String[] args) {
        print(10);
    }

    //Time Complexity: O(sqrt(n))
    public static void print(int n){
        int i = 1;

        for(;i*i < n;i++){
            if(n % i == 0)
                System.out.print(i+" ");
        }
        for(;i>=1;i--){
            if(n%i == 0)
                System.out.print((n/i)+" ");
        }
    }
}
