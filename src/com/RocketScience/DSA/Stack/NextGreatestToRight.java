package com.RocketScience.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatestToRight {
    public static void main(String[] args) {
        Arrays.stream(nextGreatest(new int[]{1,3,2,4})).forEach(System.out::println);
    }
    private static int[] nextGreatest(int[] arr){ // for left just change the direction of loop
        Stack<Integer> stack = new Stack<>();
        int[] R = new int[arr.length];
        for(int i = arr.length-1; i>=0;i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            R[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return R;
    }
}
