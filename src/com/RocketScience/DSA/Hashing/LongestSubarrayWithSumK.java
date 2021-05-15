package com.RocketScience.DSA.Hashing;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,4,7,2,9}, 13));
    }
    public static int longestSubarray(int[] a, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for(int i = 0;i<a.length;i++){
            sum += a[i];

            if(sum == k)
                return i+1;

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

            if(map.containsKey(sum-k)){
                if(maxLen < (i - map.get(sum-k))){
                    maxLen = i - map.get(sum - k);
                }
            }
        }

        return maxLen;
    }
}
