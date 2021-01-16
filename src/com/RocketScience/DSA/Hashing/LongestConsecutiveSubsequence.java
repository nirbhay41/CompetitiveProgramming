package com.RocketScience.DSA.Hashing;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(consecutive(new int[]{3, 8, 4, 5, 7}));
    }

    public static int consecutive(int[] a){
        HashSet<Integer> set = new HashSet<>();
        int len = 0,curr = 1;
        for(int x : a)
            set.add(x);

        for(int x : a){
            if(!set.contains(x-1)) { //if set doesn't contain x-1 then x is the starting point of the sequence
                curr = 1;
                while(set.contains(x+curr))
                    curr++;
                len = Math.max(len,curr);
            }
        }
        return len;
    }
}
