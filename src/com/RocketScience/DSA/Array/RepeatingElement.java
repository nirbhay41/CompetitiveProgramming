package com.RocketScience.DSA.Array;

public class RepeatingElement {
    public static void main(String[] args) {
        System.out.println(repeatingElement(new int[]{1,6,2,9,2,10}));
    }

    /*
    Conditions of the problem:
    1) Do it in O(N) time
    2) Do it in O(1) space
    3) Cannot modify array
     */
    //Here we can use Linkedlist cycle detection algorithm(hare and tortoise)
    public static int repeatingElement(int[] a){
        int slow = a[0],fast = a[0];

        do{
            slow = a[slow];
            fast = a[a[fast]];
        }while(slow != fast);

        slow = a[0];

        while(slow != fast){
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
