package com.RocketScience.DSA.Matrices;

class DMatrix{
    private final int[] A;
    private final int size;
    DMatrix(int size){
        this.size = size;
        A = new int[size];
    }
    public void set(int i,int j,int value){
        if(i == j)
            A[i-1] = value;
    }
    public int get(int i,int j){
        if(i == j)
            return A[i-1];
        else return 0;
    }
    public void display(){
        for (int i = 1; i<=size; i++) {
            for(int j = 1;j<=size;j++){
                if(i == j)
                    System.out.printf("%d ",A[i-1]);
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}

public class DiagonalMatrix {
    public static void main(String[] args) {
        DMatrix d = new DMatrix(5);
        d.set(1,1,5);
        d.set(2,2,4);
        d.set(3,3,3);
        d.set(4,4,2);
        d.set(5,5,1);
        d.display();
    }
}
