package com.RocketScience.DSA.Array;

public class MinGroupFlips {
    public static void main(String[] args) {
        flips(new int[]{1,1,1,0,0,0,1,1,0,1});
    }

    //Time Complexity: O(N)
    public static void flips(int[] a){
        int n = a.length;
        for(int i = 1;i<n;i++) {
            if (a[i] != a[i - 1])
                if (a[i] != a[0])
                    System.out.printf("From %d to ", i);
                else
                    System.out.println(i - 1);
        }

        if(a[n-1] != a[0])
            System.out.println(n-1);
    }
}
