package com.RocketScience.DSA.Array;

public class LeaderInAnArray {
    public static void main(String[] args) {
        int[] a = {7,10,4,10,6,5,2};
        leader(a);
    }
    public static void leader(int[] a){
        int n = a.length;
        int curr_leader = a[n-1];
        System.out.print(curr_leader+" ");

        for(int i = n-2;i>=0;i--){
            if(curr_leader < a[i]){
                curr_leader = a[i];
                System.out.print(curr_leader+" ");
            }
        }
    }
}
