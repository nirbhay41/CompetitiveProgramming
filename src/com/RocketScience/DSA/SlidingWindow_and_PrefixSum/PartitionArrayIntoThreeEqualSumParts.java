package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

public class PartitionArrayIntoThreeEqualSumParts {
    public static int pos1 = -1;
    public static int pos2 = -1;

    public static void main(String[] args) {
        System.out.println(partition(new int[]{3, 2, 5, 0, 2, 2, 1}));
        System.out.println(pos1+" -----> "+pos2);
    }

    // Time: O(N)   Space: O(N)
    static boolean partition(int[] a){
        int n = a.length;

        int[] pre = new int[n]; // prefix sum array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            pre[i] = sum;
        }

        int[] suf = new int[n];  // suffix sum array
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += a[i];
            suf[i] = sum;
        }

        int i = 0, j = n - 1;
        while (i < j - 1) {
            if (pre[i] == sum / 3)
                pos1 = i;

            if (suf[j] == sum / 3)
                pos2 = j;

            if (pos1 != -1 && pos2 != -1) // checking between i and j points
                return suf[pos1 + 1] - suf[pos2] == sum / 3;

            if (pre[i] < suf[j])
                i++;
            else
                j--;
        }
        return false;
    }
}
