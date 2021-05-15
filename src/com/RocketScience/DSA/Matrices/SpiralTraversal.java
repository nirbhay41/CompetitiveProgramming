package com.RocketScience.DSA.Matrices;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] a = {{6,6,2,28,2},{12,26,3,28,7},{22,25,3,4,23}};
        spiralTraversal(a);
    }

    public static void spiralTraversal(int[][] a){
        int r = a.length;
        int c = a[0].length;

        if(r == 1){
            for(int i = 0;i<c;i++)
                System.out.print(a[0][i]+" ");
        }else if(c == 1){
            for(int i = 0;i<r;i++)
                System.out.print(a[i][0]+" ");
        }else{
            int top = 0,bottom = r-1,right = c-1,left = 0;

            while((top <= bottom) && (left <= right)){
                for(int i = left;i<=right;i++)
                    System.out.print(a[top][i]+" ");
                top++;

                for(int i = top;i<=bottom;i++)
                    System.out.print(a[i][right]+" ");
                right--;

                if(top <= bottom) { // this condition is when bottom crosses top and it still prints but we don't want it to print
                    for (int i = right; i >= left; i--)
                        System.out.print(a[bottom][i] + " ");
                    bottom--;
                }

                if(left <= right) { // same goes for here
                    for (int i = bottom; i >= top; i--)
                        System.out.print(a[i][left] + " ");
                    left++;
                }
            }
        }
    }

}
