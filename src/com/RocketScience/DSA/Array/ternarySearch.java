package com.RocketScience.DSA.Array;

//https://cp-algorithms.com/num_methods/ternary_search.html
public class ternarySearch {
    public static void main(String[] args) {
        int[] a = {1,3,4,6,8,9,10};
        System.out.println(tSearch(a,8));
    }
    // Time Complexity - O(log3(n)) It does more comparisions then binary Search
    public static int tSearch(int[] a,int key){
        int low = 0,high = a.length-1,mid1,mid2;

        while (low<=high){
            mid1 = low + (high-low)/3;
            mid2 = high - (high-low)/3;

            if(a[mid1] == key) return mid1;
            if(a[mid2] == key) return mid2;

            if(key < a[mid1]) high = mid1-1; // key lies between low and mid1
            else if(key > a[mid2]) low = mid2+1; // key lies between mid2 and high
            else{ // key lies between mid1 and mid2
                low = mid1+1;
                high = mid2-1;
            }
        }
        return -1;
    }
}
