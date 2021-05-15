package com.RocketScience.DSA.Array;

public class Missing_and_Repeating_Element {
    public static void main(String[] args) {
        printElement(new int[]{4,6,1,2,2,5});
    }
    public static void printElement(int[] arr){
        for(int i = 0;i<arr.length;i++){
            int correctPos = arr[i]-1;
            while(arr[correctPos] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[correctPos];
                arr[correctPos] = temp;
                correctPos = arr[i]-1;
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i] != i+1){
                System.out.printf("Missing Element is %d\nRepeating Element is %d",i+1,arr[i]);
                break;
            }
        }
    }
}
