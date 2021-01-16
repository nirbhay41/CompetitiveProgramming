package com.RocketScience.DSA.Hashing;

import java.util.HashMap;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        int[] a = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
        System.out.println(Count(a));
    }

    public static int Count(int[] a){
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            int sum = 0,count=0;

            for (int x : a) {
                sum += x;
                if(map.containsKey(sum)){
                    count += map.get(sum);
                    map.put(sum,map.get(sum)+1);
                }else map.put(sum,1);
            }
            return count;
    }
}
