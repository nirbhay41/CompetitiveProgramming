package com.RocketScience.DSA.Strings;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(method1("geeksforgeeks"));
        System.out.println(method2("geeksforgeeks"));
    }

    public static int method1(String str){ // 2 traversals of the String
        int[] H = new int[256];

        for(int i = 0;i<str.length();i++){
            H[str.charAt(i)]++;
        }

        for(int i = 0;i<str.length();i++){
            if(H[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static int method2(String str){ // only one traversal of the string
        int[] fIndex = new int[256];
        Arrays.fill(fIndex,-1);

        for(int i = 0;i<str.length();i++){
            if(fIndex[str.charAt(i)] == -1) // here -1 represents character not seen yet
                fIndex[str.charAt(i)] = i;
            else fIndex[str.charAt(i)] = -2; // here -2 represents character seen and repeated
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0;i<256;i++){
            if(fIndex[i] >= 0)
                res = Math.min(res,fIndex[i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
