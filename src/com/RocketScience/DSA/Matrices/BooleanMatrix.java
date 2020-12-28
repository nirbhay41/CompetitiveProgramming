package com.RocketScience.DSA.Matrices;

public class BooleanMatrix {
    public static void main(String[] args) {
        int[][] a = {{ 1, 0, 0},
                     { 1, 0, 0},
                     { 1, 0, 0},
                     { 0, 0, 0}};

        booleanMatrix(a);

        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    //Time : O(R*C)    Space : O(R+C)  Medium
    public static void booleanMatrix(int[][] a) {
        boolean[] row = new boolean[a.length];
        boolean[] col = new boolean[a[0].length];

        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[i].length;j++){
                if(a[i][j] == 1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[i].length;j++){
                if(row[i] || col[j])
                    a[i][j] = 1;
            }
        }
    }
}
