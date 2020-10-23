package com.RocketScience.DSA.Array_ADT;

import java.util.Arrays;

public class PairWithSumK {
    public static void main(String[] args) {
        UsingTwoPointers(new int[]{6,3,8,10,16,7,5,2,9,14}, 10);
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
    private static void UsingHashing(int[] a,int k){ // if array is not sorted
        int max = Arrays.stream(a).max().getAsInt();
        int[] H = new int[max+1];
        Arrays.fill(H,0 );
        for (int j : a) {
            if (j > k) {
                H[j]++;
                continue;
            }
            if (H[k - j] != 0) {
                System.out.printf("%d + %d = %d\n", j, k - j, k);
            }
            H[j]++;
        }
    }
    private static void UsingTwoPointers(int[] a,int k){ // if array is sorted
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
