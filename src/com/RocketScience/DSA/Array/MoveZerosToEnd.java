package com.RocketScience.DSA.Array;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] a = {8,5,0,10,0,20};
        efficient(a);
        System.out.println(Arrays.toString(a));
    }

    //Method I : Naive Approach O(n^2)
    public static void naive(int[] a){
        int j=0;
        for(int i = 0;i<a.length;i++){
            if(a[i] == 0){
                j = i+1;
                while(a[j] == 0 && j < a.length-1) j++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            if(j == a.length-1) break;
        }
    }

    //Efficient Approach O(N)
    public static void efficient(int[] a){
        int count = 0; //count of non zero elements == index of first zero element

        for(int i = 0;i<a.length;i++){
            if(a[i] != 0){
                int temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
    }
}
