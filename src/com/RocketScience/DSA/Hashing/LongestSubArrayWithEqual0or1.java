package com.RocketScience.DSA.Hashing;

import java.util.HashMap;

public class LongestSubArrayWithEqual0or1 {
    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{0, 1,0,1}));
    }

    public static int longestSubArray(int[] a){
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); // sum --> index
        map.put(0,-1);

        for(int i = 0;i<a.length;i++){
            sum += (a[i] == 0) ? -1 : 1;

            if(map.containsKey(sum)){  // if we get the same sum then we have same no of 0's and 1's
                ans = Math.max(ans,i - map.get(sum));
            }else map.put(sum,i);
        }
        return ans;
    }
}
