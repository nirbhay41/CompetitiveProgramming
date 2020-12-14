package com.RocketScience.DSA.Mathematics;

public class LCMANDHCF {
    public static void main(String[] args) {
        System.out.println(lcm(2,5));
    }
    public static int lcm(int a ,int b){
        return (a*b)/gcd(a,b);
    }

    //Time Complexity: O(log(min(a,b)))
    public static int gcd(int a,int b){ // Same as HCF
        if(a == 0)
            return b;
        return gcd(b%a,a);
    }
}
