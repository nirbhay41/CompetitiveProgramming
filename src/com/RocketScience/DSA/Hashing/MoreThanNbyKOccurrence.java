package com.RocketScience.DSA.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MoreThanNbyKOccurrence {
    public static void main(String[] args) {
        count(new int[]{30,10,20,20,20,10,40,30,30}, 4);
    }

    //Extension of Boyer-Moore's Voting Algorithm
    //Time: O(nk)  Space : O(k)
    public static void count(int[] a,int k){
        int n = a.length;
        HashMap<Integer,Integer> map = new HashMap<>(k+1);

        for(int i = 0;i<n;i++){  // O(n)
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else if(map.size() < k-1){ // Map size will not exceed k-1
                map.put(a[i],1);
            }else {
                for(Map.Entry<Integer,Integer> e : map.entrySet()){  // O(k)
                    map.put(e.getKey(),map.get(e.getKey())-1);
                    if(e.getValue() == 0)
                        map.remove(e.getKey());
                }
            }
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int count=0;
            for (int x : a) {
                if (e.getKey() == x)
                    count++;
            }
            if(count>n/k)
                System.out.print(e.getKey()+" ");
        }
    }
}
