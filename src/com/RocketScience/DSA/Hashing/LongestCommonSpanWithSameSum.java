package com.RocketScience.DSA.Hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSum {
    public static void main(String[] args) {
        System.out.println(commonSpan(new int[]{0, 1, 0, 0, 0, 0}, new int[]{1, 0, 1, 0, 0, 1}));
    }

    public static int commonSpan(int[] a,int[] b){
        for(int i = 0;i<a.length;i++)
            a[i] = a[i] - b[i];

        //Now this is the same problem : find longest sub array with zero sum

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0,len = 0;
        for(int i = 0;i<a.length;i++){
            sum += a[i];

            if(sum == 0) // To handle sum=0 at last index
                len = i+1;
            if(map.containsKey(sum)){
                len = Math.max(len,i-map.get(sum));
            }else map.put(sum,i);
        }

        return len;
    }
}
