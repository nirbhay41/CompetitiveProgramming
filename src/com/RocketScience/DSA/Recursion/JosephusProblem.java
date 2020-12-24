package com.RocketScience.DSA.Recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println(josephus(5, 3));
    }

    //Very Important Problem
    //Time: O(n)
    public static int josephus(int n,int k){ // n --> no of persons
        if(n == 1){
            return 0;
        }

        return (josephus(n-1,k) + k)%n;
    }
}
