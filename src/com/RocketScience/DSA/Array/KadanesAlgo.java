package com.RocketScience.DSA.Array;

public class KadanesAlgo {
    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[]{1,2,-3,4,-5,6}));
    }

    //Kadanes Algorithm
    public static int maxSumSubArray(int[] a){
        int maxEnding = a[0],res = a[0];

        for(int i = 1;i<a.length;i++){
            maxEnding = Math.max(maxEnding+a[i],a[i]);
            res = Math.max(maxEnding,res);
        }
        return res;
    }

}
