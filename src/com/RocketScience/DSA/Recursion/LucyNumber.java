package com.RocketScience.DSA.Recursion;

public class LucyNumber {
    static int counter = 2;
    public static void main(String[] args) {
        System.out.println(isLucky(19));
    }

    //Time: O(sqrt(n))    Space: O(sqrt(n))
    public static boolean isLucky(int n){
        if(n < counter)
            return true;
        if(n%counter == 0)
            return false;

        int nextPos = n - n/counter;
        counter++;

        return isLucky(nextPos);
    }
}
