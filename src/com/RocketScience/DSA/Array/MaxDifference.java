package com.RocketScience.DSA.Array;

public class MaxDifference {
    public static void main(String[] args) {

    }

    //Time Complexity: O(N)
    public static int diff(int[] a){
        int res = a[1] - a[0],minVal = a[0];

        for(int j = 1;j<a.length;j++){
            res = Math.max(res,a[j] - minVal);
            minVal = Math.min(minVal,a[j]);
        }
        return res;
    }
}
