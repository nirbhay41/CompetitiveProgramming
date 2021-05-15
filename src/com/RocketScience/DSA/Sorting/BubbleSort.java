package com.RocketScience.DSA.Sorting;

/*
Time Complexity of Bubble Sort is O(n^2)
It is stable
After 1 pass we get the largest element in the array.
So we can use this property and can get n largest element by just running n passes
 */
public class BubbleSort{
    public static void sort(int[] a){
        bubbleSort(a);
    }
    private static void bubbleSort(int[] a){
        final int n = a.length;
        int temp;
        boolean flag;
        for(int i = 0;i<n-1;i++){ //for n-1 passes
            flag = false;
            for(int j = 0;j<n-1-i;j++){ // for comparisons
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
