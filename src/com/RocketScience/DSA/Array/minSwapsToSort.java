package com.RocketScience.DSA.Array;

import java.util.Arrays;
import java.util.HashMap;

public class minSwapsToSort {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{1, 5, 4, 3, 2}));
    }

    //There is also an another method using graph
    //Method : Using HashMap
    //Time Complexity : O(nlogn)
    //Space Complexity : O(n)
    public static int minSwaps(int[] a) {
        int[] temp = Arrays.copyOfRange(a, 0,a.length);
        Arrays.sort(temp);
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i],i);
        }
        for(int i = 0;i<a.length;i++){
            if(a[i] != temp[i]){
                ans++;
                int x = a[i];
                swap(a,i,map.get(temp[i]));
                map.put(x,map.get(temp[i]));
                map.put(temp[i],i);
            }
        }
        return ans;
    }
    public static void swap(int[] a ,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
