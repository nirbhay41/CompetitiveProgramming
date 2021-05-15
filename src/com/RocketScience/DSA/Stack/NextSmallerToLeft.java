package com.RocketScience.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerToLeft {
    public static void main(String[] args) {
        Arrays.stream(nextGreater(new int[]{6,3,38,98,16})).forEach(System.out::println);
    }
    public static int[] nextGreater(int[] arr){ // for right just change the directions of loop
        Stack<Integer> stack = new Stack<>();
        int[] R = new int[arr.length];
        int i = 0;
        for(int x : arr){
            if(stack.isEmpty())
                R[i] = -1;
            else{
                if(stack.peek() < x)
                   R[i] = stack.peek();
                else if(stack.peek() >= x){
                    while(!stack.isEmpty() && stack.peek() >= x){
                        stack.pop();
                    }
                    if(stack.isEmpty())
                        R[i] = -1;
                    else
                        R[i] = stack.peek();
                }
            }
            stack.push(x);
            i++;
        }
        return R;
    }
}
