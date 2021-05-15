package com.RocketScience.DSA.Matrices;

import java.util.Arrays;

public class Median_Of_Matrix {
    public static void main(String[] args) {
        int[][] a = {{1,10,20},{15,25,35},{5,30,40}};
        System.out.println(median(a));
    }

    //Median of a Row wise sorted matrix:
    //Time Complexity: O(r*log(max-min)*log(c))
    public static int median(int[][] a){
        int r = a.length,c = a[0].length;
        int min = a[0][0],max = a[0][c-1];

        //finding max and min in matrix
        for(int i = 1;i<r;i++){
            min = Math.min(a[i][0],min);
            max = Math.max(a[i][c-1],max);
        }

        //finding the position of median element
        int medianPos = (r*c+1)/2;

        //doing binary search in the range min to max
        while(min < max) {
            int mid = (min + max) / 2, midPos = 0;

            //for every row do binary search to find the position of mid
            for (int i = 0; i < r; i++) {
                midPos += Math.abs(Arrays.binarySearch(a[i], mid) + 1);
                //binarySearch function returns index of element if found
                //and if not found then it returns the index of the element where it should be present
                //but in negative. So that's why we are using abs()
            }

            if (midPos < medianPos) {
                min = mid + 1;
            } else max = mid; // if we get midPos == medianPos, then also search in the left side
        }

        return min;
    }
}
