package com.RocketScience.DSA.Mathematics;

public class CountDigitsInANumber {
    public static void main(String[] args) {
        System.out.println(countDigit(1345));
    }

    //Time Complexity : O(d) where d is the no of digits in the number
    public static int iterative(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            count++;
        }
        return count;
    }

    //Time Complexity : O(1)
    public static int countDigit(int n){
        return (int)Math.floor(Math.log10(n)+1);
    }
}
