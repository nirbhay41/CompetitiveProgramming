package com.RocketScience.DSA.BinarySearch;

//LeetCode Problem 1539
public class KthMissingNumber {
    public static void main(String[] args) {

    }

    //Time: O(N)
    public static int method1(int[] a,int k){
        int d = 1,count = 0;

        for(int i = 0;i< a.length;i++){
            if(a[i] - i != d){
                count += (a[i] - i) - d;
                if(count >= k){
                    int temp = a[i]-1;
                    while(count > k){
                        temp--;
                        count--;
                    }
                    return temp;
                }
                d = a[i] - i;
            }
        }
        return a[a.length-1]+(k-count);
    }
    //Time:O(logn)
    public static int findKthPositive(int[] a, int k) {
        int l = 0, r = a.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (a[m] - 1 - m < k) // no of missing no is a[m] - 1 - m
                l = m + 1;
            else
                r = m;
        }
        return l + k;
    }
}

