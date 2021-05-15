package com.RocketScience.DSA.Array;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        merge2(new int[]{1,2,8,9,12,13}, new int[]{3,4,7,10}, 6, 4);
    }
    /*
    Approach I : Using Insertion Sort
    https://medium.com/swlh/merge-two-sorted-arrays-without-using-extra-space-o-1-based-on-insertion-sort-simple-approach-e928756fb2f1
    Time Complexity : O(n*m) with const space
     */
    public static void merge1(int[] a, int[] b, int n, int m) {
        for(int i = 0;i<n;i++){
            if(a[i] > b[0]){
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;
                Arrays.sort(b);
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    /*
    Approach II : Using Gap Method
    Time Complexity : O(nlogn) with const space
    https://medium.com/swlh/merge-two-sorted-arrays-without-extra-space-efficiently-o-1-gap-method-detailed-simplified-57a336146601
     */
    static int nextGap(int gap) {
        return gap <= 1 ? 0 : (int)Math.ceil((double)gap/2);
    }

    public static void merge2(int[] a,int[] b,int n,int m){
        int gap = (int)Math.ceil((double)(n+m)/2);
        int i,j;

        while(gap > 0){
            //Comparing Elements in first array
            for(i = 0;i+gap<n;i++){
                if(a[i] > a[i+gap]){
                    int temp = a[i];
                    a[i] = a[i+gap];
                    a[i+gap] = temp;
                }
            }

            //Comparing Elements in both the array
            for(j = gap > n ? gap-n : 0;i<n && j<m;i++,j++){
                if(a[i] > b[j]){
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                }
            }

            //Comparint Elements in second array
            if(j < m){
                for(j = 0;j+gap < m;j++){
                    if(b[j] > b[j+gap]){
                        int temp = b[j];
                        b[j] = b[j+gap];
                        b[j+gap] = temp;
                    }
                }
            }

            gap = nextGap(gap);
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
