package com.RocketScience.DSA.Array;

public class FrequencyInConstTime {
    public static void main(String[] args) {
        count(new int[]{2,3,2,3,5});
    }

    public static void count(int[] a){
        int i = 0,elementIndex,n = a.length;

        while(i < n){
            // If this element is already processed, then nothing to do
            if(a[i] <= 0){
                i++;
                continue;
            }
            // Find index corresponding to this element
            elementIndex = a[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't lose anything.
            if(a[elementIndex] > 0){
                a[i] = a[elementIndex];
                a[elementIndex] = -1;
            }else{
                // If this is NOT first occurrence of arr[i],
                // then decrement its count.
                a[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                a[i] = 0;
                i++;
            }
        }

        System.out.println("Below are counts of all elements");
        for (i = 0; i < n; i++)
            System.out.println(i+1 + "->" + Math.abs(a[i]));
    }
}
