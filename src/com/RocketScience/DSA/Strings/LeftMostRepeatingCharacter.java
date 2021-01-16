package com.RocketScience.DSA.Strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(method1("abbccdd"));
        System.out.println(method2("geeksforgeeks"));
    }

    public static int method1(String str){
        int[] fIndex = new int[256];
        Arrays.fill(fIndex,-1);

        int res = Integer.MAX_VALUE;

        for(int i = 0;i<str.length();i++){
            int fi = fIndex[str.charAt(i)];
            if(fi == -1)
                fIndex[str.charAt(i)] = i;
            else res = Math.min(res,fi);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int method2(String str){
        boolean[] visited = new boolean[256];
        int res = -1;
        for(int i = str.length()-1;i>=0;i--){
            if(visited[str.charAt(i)]){
                res = i;
            }else visited[str.charAt(i)] = true;
        }
        return res;
    }
}
