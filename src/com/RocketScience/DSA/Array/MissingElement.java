package com.RocketScience.DSA.Array;

import java.util.Arrays;

public class MissingElement {
    public static void main(String[] args) {
        multiple_missing_element_using_hashing(new int[]{6,7,8,9,11,12,15});
    }
    private static void one_missing_element_in_sorted_Array(int[] arr){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] - i != arr[0]){
                System.out.println("Missing Element is "+(i+arr[0]));
                break;
            }
        }
    }
    private static void multiple_missing_element_in_sorted_Array(int[] arr){ // Time Complexity is O(n)
        int diff = arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i] - i != diff){
                while(diff < arr[i] - i){ // Its Time Complexity can be neglected
                    System.out.println("Missing Element is "+(i+diff));
                    diff++;
                }
            }
        }
    }
    private static void multiple_missing_element_using_hashing(int[] arr){
        int low = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt();
        int[] H = new int[high+1];
        Arrays.fill(H,0);
        for (int j : arr) {
            H[j]++;
        }
        for(int i = low;i<H.length;i++){
            if(H[i] == 0){
                System.out.println("Missing Element is "+i);
            }
        }
    }
}
