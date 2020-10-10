package com.RocketScience.DSA.Stack;

public class MaxAreaOfRectangleOfBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(max_area(new int[][]{{0}}));
    }
    private static int max_area(int[][] matrix){
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[][] V = new int[matrix.length][5];

        for(int j = 0;j<matrix[0].length;j++){
            V[0][j] = matrix[0][j];
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    V[i][j] = 0;
                }else V[i][j] = V[i-1][j] + matrix[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int[] x : V){
            max = Math.max(max,MAH.area(x));
        }
        return max;
    }
}
