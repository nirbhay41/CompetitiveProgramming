package com.RocketScience.DSA.Recursion;

public class ToweOfHanoi {
    public static void main(String[] args) {
        TOH(3,'A', 'B', 'C');
    }

    // No of movements of disc: (2^n - 1)
    public static void TOH(int n,char A,char B,char C){ // source, temp , dest
        if(n == 1){
            System.out.printf("Move 1 from %c to %c\n",A,C);
            return;
        }
        TOH(n-1, A,C,B);
        System.out.printf("Move %d from %c to %c\n",n,A,C);
        TOH(n-1,B,A,C);
    }
}
