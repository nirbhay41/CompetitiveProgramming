package com.RocketScience.DSA.Stack;

import java.util.Stack;

//Maximum area of histogram
public class MAH {
    public static void main(String[] args) {
        System.out.println(area(new int[]{2,1,5,6,2,3}));
    }
    public static int area(int[] hist){
        int[] left = NSL(hist);
        int[] right = NSR(hist);

        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<hist.length;i++){
            ans = Math.max(ans,(right[i]-left[i]-1)*hist[i]);
        }

        return ans;
    }
    private static int[] NSL(int[] hist){ // We are storing indexes in stack of the elements
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[hist.length];
        int i = 0,pseudo_index = -1;
        for(int x : hist){
            while(!stack.isEmpty() && hist[stack.peek()] >= x){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? pseudo_index : stack.peek();
            stack.push(i);
            i++;
        }
        return left;
    }
    private static int[] NSR(int[] hist){ // We are storing indexes in stack of the elements
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[hist.length];
        int pseudo_index = hist.length;
        for(int i = hist.length-1;i>=0;i--){
            while(!stack.isEmpty() && hist[stack.peek()] >= hist[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? pseudo_index : stack.peek();
            stack.push(i);
        }

        return right;
    }
}
