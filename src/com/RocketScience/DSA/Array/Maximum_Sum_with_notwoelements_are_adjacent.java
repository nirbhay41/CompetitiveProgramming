package com.RocketScience.DSA.Array;

//Very important question
public class Maximum_Sum_with_notwoelements_are_adjacent {
    public static void main(String[] args) {
        System.out.println(findmaxSum(new int[]{5, 10, 10, 100, 5, 6}));
    }
    public static int findmaxSum(int[] a){
        int incl = a[0];
        int excl = 0;
        int excl_new;

        for (int i = 1;i<a.length;i++) {
            excl_new = Math.max(incl,excl);
            incl = excl + a[i];
            excl = excl_new;
        }
        return Math.max(incl,excl);
    }
}
