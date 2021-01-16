package com.RocketScience.DSA.Hashing;

import java.util.HashMap;

public class CountDistinctsElementinWindow {
    public static void main(String[] args) {
        count(new int[]{10,20,20,10,30,40,10},4);
    }

    public static void count(int[] a,int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<k;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }

        System.out.print(map.size()+" ");

        for(int i = k;i<a.length;i++){
            map.put(a[i-k],map.get(a[i-k])-1);

            if(map.get(a[i-k]) == 0)
                map.remove(a[i-k]);

            map.put(a[i],map.getOrDefault(a[i],0)+1);

            System.out.print(map.size()+" ");
        }
    }
}
