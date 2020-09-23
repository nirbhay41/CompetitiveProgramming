package com.RocketScience.DSA.Array_ADT;

import java.util.Arrays;

public class PairWithSumK {
    public static void main(String[] args) {
        sorted_pairWithSum(new int[]{6,3,8,10,16,7,5,2,9,14}, 10);
    }
    private static void naive_pairWithSum(int[] a,int k){ // O(n^2) Solution
        for(int i = 0;i<a.length-1;i++){
            for(int j = i+1;j<a.length;j++){
                if(a[i] + a[j] == k){
                    System.out.printf("%d + %d = %d\n", a[i],a[j],k);
                }
            }
        }
    }
    private static void fast_pairWithSum(int[] a,int k){
        int max = Arrays.stream(a).max().getAsInt();
        int[] H = new int[max+1];
        Arrays.fill(H,0 );
        for(int i = 0;i<a.length;i++){
            if(a[i] > k){
                H[a[i]]++;
                continue;
            }
            if(H[k-a[i]] != 0){
                System.out.printf("%d + %d = %d\n",a[i],k-a[i],k);
            }
            H[a[i]]++;
        }
    }
    private static void sorted_pairWithSum(int[] a,int k){
        int i = 0,j = a.length-1;
        Arrays.sort(a);
        while(i < j){
            if(a[i] + a[j] > k) j--;
            else if(a[i] + a[j] < k) i++;
            else {
                System.out.printf("%d + %d = %d\n",a[i],a[j],k);
                i++;
                j--;
            }
        }
    }

}
