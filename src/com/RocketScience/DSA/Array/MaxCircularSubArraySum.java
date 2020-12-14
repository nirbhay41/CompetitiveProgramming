package com.RocketScience.DSA.Array;

public class MaxCircularSubArraySum {
    public static void main(String[] args) {
        System.out.println(maxCircularSum2(new int[]{1, 2, -3, 4, -5, 6}));
    }

    //Method - I : Naive Solution O(N^2)
    public static int maxCircularSum1(int[] a){
        int res = a[0];

        for(int i = 0;i<a.length;i++){
            int curr_max = a[i];
            int curr_sum = a[i];
            for(int j = 1;j<a.length;j++){
                int index = (i+j)%a.length;
                curr_sum += a[index];
                curr_max = Math.max(curr_max,curr_sum);
            }
            res = Math.max(res,curr_max);
        }

        return res;
    }

    //Method-II : Efficient Solution O(N)
    public static int maxCircularSum2(int[] a){
        int max_normal = KadanesAlgo.maxSumSubArray(a);
        if(max_normal < 0) //Very Important Condition  (If every element in array is negative then this will
            return max_normal;  //give max value

        int arr_sum = 0;
        for(int i = 0;i<a.length;i++){
            arr_sum += a[i];
            a[i] = -a[i]; //inverting the array
        }

        int max_circular = arr_sum + KadanesAlgo.maxSumSubArray(a);
        return Math.max(max_circular,max_normal);
    }
}
