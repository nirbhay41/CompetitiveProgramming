package com.RocketScience.DSA.Recursion;

public class Rope_Cutting {
    public static void main(String[] args) {
        System.out.println(maxCuts(9, 2, 2, 2));
    }

    public static int maxCuts(int n,int a,int b,int c){
        if(n == 0)
            return 0;
        if(n < 0)
            return -1;

        int x = maxCuts(n-a,a,b,c);
        int y = maxCuts(n-b,a,b,c);
        int res = Math.max(Math.max(x,y),maxCuts(n-c,a,b,c));

        return res == -1 ? -1 : res+1;
    }
}
