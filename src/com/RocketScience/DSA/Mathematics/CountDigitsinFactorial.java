package com.RocketScience.DSA.Mathematics;

public class CountDigitsinFactorial {
    public static void main(String[] args) {
        System.out.println(method2(42));
    }

    //Method I: This method works on if n < 10^6 (Using log property)
    public static int method1(int n){
        if (n < 0)
            return 0;
        if (n <= 1)
            return 1;

        double digits = 0;
        for (int i=2; i<=n; i++)
            digits += Math.log10(i);

        return (int)(Math.floor(digits)) + 1;
    }

    //Method II: Kamenetsky’s formula if n > 10^6
    public static long method2(int n){
        if (n < 0)
            return 0;
        if (n <= 1)
            return 1;

        // Use Kamenetsky formula to calculate
        double x = (n * Math.log10(n / Math.E) + Math.log10(2 * Math.PI * n) / 2.0);

        return (long)Math.floor(x) + 1;
    }
}
