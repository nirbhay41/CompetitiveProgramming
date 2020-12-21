package com.RocketScience.DSA.Mathematics;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(power2(361, 163));
    }

    //Time Complexity: O(logn) and Space Complexity: O(n)
    private static int power1(int a,int N){
        if(N == 0) return 1;
        else if(N == 1) return a;
        else{
            int R = power1(a,N/2);
            if((N&1) == 0)
                return R*R;
            else return R*a*R;
        }
    }

    //Binary Exponentiation Time: O(logn) , Space: O(1)
    private static int power2(int x,int n){
        int res = 1;
        while(n > 0){
            if((n&1) != 0){
                //Bit is 1
                res = (res * x); // for modulo operation res = (res * x)%M;
            }
            x = (x*x); // x = (x*x)%M;
            n = n >> 1;
        }
        return res;
    }
    private static long power_modulo(final int a, final int N, int M) {
        if (N == 0) {
            return 1;
        } else {
            final long R = power_modulo(a, N / 2, M);
            if (N % 2 == 0) {
                return (R * R) % M;
            } else {
                return (R * R * a) % M;
            }
        }
    }
}
