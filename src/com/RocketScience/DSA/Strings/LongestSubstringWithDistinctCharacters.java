package com.RocketScience.DSA.Strings;

import java.util.Arrays;

public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("abaacdbab"));
    }

    //Time: O(N)     Space: O(CHAR)  where CHAR=256
    public static int longestSubstring(String str){
        int[] prev = new int[256]; // stores the index of character when its last occurred
        Arrays.fill(prev,-1);
        int i = 0,res = 0,maxEnd;
        //Compute maxEnd for every j
        for(int j = 0;j<str.length();j++){
            //if i is max it means str.charAt(j) doesn't appear in the string from i to j-1 so we can add it
            //but if it appeared then we will count length from just after it : prev[str.charAt(j)]+1
            i =  Math.max(i,prev[str.charAt(j)]+1);
            maxEnd = j-i+1;
            res = Math.max(res,maxEnd);
            prev[str.charAt(i)] = j;
        }

        return res;
    }
}
