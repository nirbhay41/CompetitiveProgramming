package com.RocketScience.DSA.Array;

public class max_and_min_in_an_array {
    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax3(arr, arr_size);
        System.out.printf("Minimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
    //Method - I : O(n)
    //In this method, total number of comparisons is 1 + 2(n-2) in worst case and 1 + n – 2 in best case
    static class Pair {
        int min;
        int max;
    }
    static Pair getMinMax1(int arr[], int n) {
        Pair minmax = new  Pair();
        int i;

        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i] > minmax.max)
                minmax.max = arr[i];
            else if (arr[i] < minmax.min)
                minmax.min = arr[i];
        }
        return minmax;
    }

    //Method - II : Tournament Method O(n) (Divide and Conquer)
    /*
       Thus, the approach does 3n/2 -2 comparisons if n is a power of 2.
       And it does more than 3n/2 -2 comparisons if n is not a power of 2.
    */
    static Pair getMinMax2(int arr[], int low, int high) {
        Pair minmax = new Pair();
        Pair mml;
        Pair mmr;
        int mid;

        // If there is only one element
        if (low == high) {
            minmax.max = arr[low];
            minmax.min = arr[low];
            return minmax;
        }

        // If there are two elements
        if (high == low + 1) {
            if (arr[low] > arr[high]) {
                minmax.max = arr[low];
                minmax.min = arr[high];
            } else {
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            return minmax;
        }

        // If there are more than 2 elements
        mid = (low + high) / 2;
        mml = getMinMax2(arr, low, mid);
        mmr = getMinMax2(arr, mid + 1, high);

        minmax.min = Math.min(mml.min, mmr.min);
        minmax.max = Math.max(mml.max, mmr.max);

        return minmax;
    }

    //Method - III : Compare in Pairs O(n) [Best Approach]
    /*
    If n is odd then initialize min and max as first element.
    If n is even then initialize min and max as minimum and maximum of the first two elements respectively.
    For rest of the elements, pick them in pairs and compare their
    maximum and minimum with max and min respectively.
     */
    static Pair getMinMax3(int arr[], int n) {
        Pair minmax = new Pair();
        int i;

        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        }else {
            minmax.min = arr[0];
            minmax.max = arr[0];
            i = 1;
        }

        /* In the while loop, pick elements in pair and
           compare the pair with max and min so far */
        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
        }

        return minmax;
    }

}
