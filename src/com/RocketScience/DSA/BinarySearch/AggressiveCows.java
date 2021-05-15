package com.RocketScience.DSA.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

//Time Complexity : O(nlogn)
public class AggressiveCows {
    static Scanner sc = new Scanner(System.in);
    static int n,c;
    public static void main(String[] args) {
        int t = sc.nextInt(); //test cases
        while(t-- > 0){
            solve();
        }
    }

    private static void solve() {
        n = sc.nextInt();  // no of stalls
        c = sc.nextInt();  // no of cows
        int[] a = new int[n]; // locations of stalls
        int i;
        for(i = 0;i<n;i++)
            a[i] = sc.nextInt();
        Arrays.sort(a);
        int ans = binarySearch(a);
        System.out.println(ans);
    }

    public static int binarySearch(int[] a){
        int low = 1,high = a[n-1],mid;
        int max = -1;
        while(low < high){
            mid = low + (high-low)/2;

            //Check for the current gap
            if(isValid(a,mid)){
                max = mid;
                low = mid+1;  // move to right for min large distance
            }else high = mid;
        }
        return max;
    }

    public static boolean isValid(int[] a,int gap){
        int cows = 1; // first cow is already placed at index 0
        int pos = 0; // starting position

        for(int i = 1;i<n;i++){
            if(a[i] - a[pos] >= gap){
                pos = i;
                cows++;
                if(cows == c)
                    return true;
            }
        }
        return false;
    }
}
