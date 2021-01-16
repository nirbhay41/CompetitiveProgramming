package com.RocketScience.DSA.Sorting;

import java.util.Arrays;

public class MeetMaxGuest {
    public static void main(String[] args) {
        int[] arr = {900,600,700};
        int[] dep = {1000,800,730};

        System.out.println(maxGuest(arr, dep));
    }

    //Time: O(nlogn)
    public static int maxGuest(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1,j = 0,res = 1,curr = 1; // i = 1 because we already considered the first arrival

        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                i++;
                curr++; // increase the no of guest
            }else{
                j++;
                curr--; // decrease the no of guest
            }
            res = Math.max(res,curr);
        }

        return res;
    }
}
