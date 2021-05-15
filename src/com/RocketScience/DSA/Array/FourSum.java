package com.RocketScience.DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public static void main(String[] args) {
        findSum(new int[]{10,2,3,4,5,7,8}, 23).forEach(System.out::println);
    }

    // Time Complexity : O(n^3)
    public static ArrayList<ArrayList<Integer>> findSum(int[] a,int target){
        ArrayList<ArrayList<Integer>> R = new ArrayList<>();
        if(a == null || a.length == 0)
            return R;
        Arrays.sort(a); // Very Imp Step for algorithm to work

        for(int i = 0;i<a.length;i++){
            for(int j = i+1;j<a.length;j++){
                int target2 = target - a[i] - a[j];
                int start = j+1;
                int end = a.length-1;

                while (start < end){
                    int twoSum = a[start] + a[end];

                    if(twoSum < target2) start++;
                    else if(twoSum > target2) end--;
                    else{
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(a[i]);
                        quad.add(a[j]);
                        quad.add(a[start]);
                        quad.add(a[end]);
                        R.add(quad);

                        //Check for duplicates
                        while (start < end && a[start] == quad.get(2)) start++;
                        while (start < end && a[end] == quad.get(3)) end--;
                    }
                }
                while (j+1 < a.length && a[j+1] == a[j]) j++; //Check for duplicates
            }
            while (i+1 < a.length && a[i+1] == a[i])i++; // Check for duplicates
        }
        return R;
    }
}
