package com.RocketScience.DSA.Matrices;

public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 2, 3},{3, 2, 1}};

        System.out.println(findMinOperation(matrix, matrix.length));
        printMatrix(matrix, 2);
    }

    static void printMatrix(int[][] matrix, int n){
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j)
                System.out.print(matrix[i][j] +" ");
            System.out.println();
        }
    }

    //Time : O(N*N)  Space: O(N)  Medium
    static int findMinOperation(int[][] matrix, int n){
        // Initialize the sumRow[] and sumCol[] array to 0
        int[] sumRow = new int[n];
        int[] sumCol = new int[n];

        // Calculate sumRow[] and sumCol[] array
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                sumRow[i] += matrix[i][j];
                sumCol[j] += matrix[i][j];
            }
        }

        // Find maximum sum value in either row or in column
        int maxSum = 0;
        for (int i = 0; i < n; ++i){
            maxSum = Math.max(maxSum, sumRow[i]);
            maxSum = Math.max(maxSum, sumCol[i]);
        }

        int count = 0;
        for (int i = 0, j = 0; i < n && j < n;){
            // Find minimum increment required in either row or column
            int diff = Math.min(maxSum - sumRow[i], maxSum - sumCol[j]);

            // Add difference in corresponding cell, sumRow[] and sumCol[] array
            matrix[i][j] += diff;
            sumRow[i] += diff;
            sumCol[j] += diff;

            // Update the count variable
            count += diff;

            // If ith row satisfied, increment ith value for next iteration
            if (sumRow[i] == maxSum)
                ++i;

            // If jth column satisfied, increment jth value for next iteration
            if (sumCol[j] == maxSum)
                ++j;
        }
        return count;
    }
}
