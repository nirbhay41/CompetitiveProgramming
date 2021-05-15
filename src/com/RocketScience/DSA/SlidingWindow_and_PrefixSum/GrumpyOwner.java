package com.RocketScience.DSA.SlidingWindow_and_PrefixSum;

//Leetcode Problem(Medium) - Grumpy Bookstore Owner
public class GrumpyOwner {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0, maxMakeSatisfied = 0;
        for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0) { satisfied += customers[i]; } // if the owner is not grumpy
            else { winOfMakeSatisfied += customers[i]; } // if the owner is grumpy
            if (i >= X) { // slide the window
                winOfMakeSatisfied -= grumpy[i - X] * customers[i - X];
            }
            maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
        }
        return satisfied + maxMakeSatisfied;
    }
}
