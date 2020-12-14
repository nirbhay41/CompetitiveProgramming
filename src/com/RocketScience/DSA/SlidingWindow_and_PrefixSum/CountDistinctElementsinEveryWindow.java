package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsinEveryWindow {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> countDistinct(int a[], int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<k;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        list.add(map.size());
        for(int i = k;i<n;i++){
            if(map.get(a[i-k]) == 1){
                map.remove(a[i-k]);
            }else{
                map.put(a[i-k],map.get(a[i-k])-1);
            }

            map.put(a[i],map.getOrDefault(a[i],0)+1);
            list.add(map.size());
        }
        return list;
    }
}
