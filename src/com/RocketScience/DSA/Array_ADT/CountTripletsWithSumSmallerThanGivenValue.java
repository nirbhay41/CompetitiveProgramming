package com.RocketScience.DSA.Array_ADT;

import java.util.Arrays;

public class CountTripletsWithSumSmallerThanGivenValue {
    public static void main(String[] args) {
        System.out.println(countTriplets(new long[]{5, 1, 3, 4, 7}, 12));
    }
    //Time Complexity : O(n^2)
    static long countTriplets(long[] a, final int sum) {
        Arrays.sort(a);
        int start,end;
        int count = 0;
        for(int i = 0;i<a.length;i++){
            start = i+1;
            end = a.length-1;

            while(start<end){
                if(a[i] + a[start] + a[end] >= sum)
                    end--;
                else{
                    count += (end-start);
                    start++;
                }
            }
        }
        return count;
    }
}
