package com.RocketScience.DSA.Matrices;

import java.util.Scanner;
/*
This is using Row-major technique to store non-zero elements
 */
class LMatrix{
    private final int[] A;
    private final int size;
    public LMatrix(int size) {
        this.size = size;
        A = new int[size*(size+1)/2];
    }
    public void set(int i,int j,int x){
        if(i >= j)
            A[(i*(i-1))/2+j-1] = x;
    }
    public int get(int i,int j){
        if(i >= j)
            return A[(i*(i-1))/2+j-1];
        else return 0;
    }
    public void display(){
        for(int i =1;i<=size;i++){
            for(int j = 1;j<=size;j++){
                if(i>=j)
                    System.out.printf("%d ",A[(i*(i-1))/2+j-1]);
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}

public class LowerTriangleMatrix {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter Dimension of a matix: ");
        int n = sc.nextInt();
        LMatrix m  = new LMatrix(n);

        System.out.println("Enter Values in Matrix: ");
        for (int i = 1; i <= n; i++) {
            for(int j = 1;j<=n;j++){
                int x = sc.nextInt();
                m.set(i,j,x);
            }
        }
        System.out.println("Printing Matrix: ");
        m.display();
    }
}
