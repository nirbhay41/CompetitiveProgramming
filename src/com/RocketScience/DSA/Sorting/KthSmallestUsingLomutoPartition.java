package com.RocketScience.DSA.Sorting;

public class KthSmallestUsingLomutoPartition {
    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4}; // 2 3 4 5 6 8
        System.out.println(kthSmallest(a, 2));
    }

    //Time: O(n)
    public static int kthSmallest(int[] a,int k){
        int n = a.length;
        int low = 0,high = n-1;

        while(low <= high){
            int pivot = partition(a,low,high);

            if(pivot == n-k) // for largest n-k
                return a[pivot];
            else if(pivot > n-k)
                high = pivot-1;
            else low = pivot+1;
        }
        return -1;
    }

    //Lomuto Partition Time: O(n)
    private static int partition(int[] a, int low, int high) {
        int i = low-1;
        int pivot = a[high];

        for(int j = low;j<high;j++){
            if(a[j] < pivot){
                i++;
                swap(a,i,j);
            }
        }
        swap(a,i+1,high);
        return i+1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
