package com.RocketScience.DSA.Array;

public class SmallestPositiveMissing {
    public static void main(String[] args) {
        System.out.println(findMissingPositive(new int[]{0,-10,1,3,-20}));
    }
    public static int findMissingPositive(int[] a){
        int n = a.length,correct_pos;

        for(int i = 0;i<n;i++){
            correct_pos = a[i]-1;
            while((1 <= a[i] && a[i] <= n) && (a[i] != a[correct_pos])){
                int temp = a[i];
                a[i] = a[correct_pos];
                a[correct_pos] = temp;
                correct_pos = a[i] - 1;
            }
        }

        for(int i = 0;i<n;i++){
            if(i+1 != a[i])
                return i+1;
        }
        return n+1;
    }
}
