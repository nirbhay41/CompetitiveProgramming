package com.RocketScience.CompetitiveTricks;

public class FastExponentiation {
    public static void main(String[] args) {
        System.out.println(power(2,10,7));
        System.out.println(power(2,10));
    }
    /*
     The Simple brute force approach for computing the a to the power of N is O(N) and its too slow for big values
     But this approach is of O(log N) which very fast than O(N)
     */
    private static int power(int a,int N){
        if(N == 0) return 1;
        else if(N == 1) return a;
        else{
            int R = power(a,N/2);
            if((N&1) == 0)
                return R*R;
            else return R*a*R;
        }
    }
    private static long power(final int a, final int N, int M) {
        if (N == 0) {
            return 1;
        } else {
            final long R = power(a, N / 2, M);
            if (N % 2 == 0) {
                return (R * R) % M;
            } else {
                return (R * R * a) % M;
            }
        }
    }
}
