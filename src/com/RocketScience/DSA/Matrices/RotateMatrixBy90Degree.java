package com.RocketScience.DSA.Matrices;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        rotate(a);
        for (int[] rows : a) {
            for (int columns : rows) {
                System.out.print(columns + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] a){
        transpose(a);

        //Reverse the rows
        int r = a.length;
        for(int i = 0;i<r/2;i++){
            for(int j =0;j<a[i].length;j++){
                int temp = a[i][j];
                a[i][j] = a[r-i-1][j];
                a[r-i-1][j] = temp;
            }
        }
    }

    public static void transpose(int[][] a) {
        int i = 0,j = 0;
        while (i < a.length) {
            while (j < a[i].length) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
                j++;
            }
            i++;
            j = i;
        }
    }
}
