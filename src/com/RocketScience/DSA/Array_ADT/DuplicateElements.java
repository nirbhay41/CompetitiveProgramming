package com.RocketScience.DSA.Array_ADT;

public class  DuplicateElements {
    public static void main(String[] args) {
        NumberOfDuplicates(new int[]{1,4,5,5,5,5,6,8,8});
    }
    /*
      We can also use hashing to find Duplicates
     */
    private static void DuplicatesInSortedArray(int[] arr){
        int lastDuplicate = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1] && arr[i] != lastDuplicate){
                System.out.println("Duplicate Element is "+arr[i]);
                lastDuplicate = arr[i];
            }
        }
    }
    private static void NumberOfDuplicates(int[] arr){
        int j;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == arr[i+1]){
                j = i+1;
                while (arr[j] == arr[i]) j++;
                System.out.printf("%d is appearing %d times", arr[i],(j-i));
                i = j-1;
            }
        }
    }
}
