package com.RocketScience.DSA.Sorting;

public class KthSmallestUsingLomutoPartition {
    public static void main(String[] args) {
        int[] a = {6,2,8,4,9,3,5}; // 2 3 4 5 6 8
        System.out.println(kthSmallest(a, 3));
    }

    //Time: O(n)
    public static int kthSmallest(int[] a,int k){
        int n = a.length;
        int low = 0,high = n-1;

        while(low <= high){
            int pivot = partition(a,low,high);

            if(pivot == k-1) // for largest n-k
                return a[pivot];
            else if(pivot > k-1)
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
