package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class MinStackWithConstSpace {
    private final static Stack<Integer> stack = new Stack<>();
    private static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        push(5);
        push(2);
        System.out.println(getMin());
        push(8);
        push(1);
        pop();
        System.out.println(getMin());
    }
    private static void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            Min = x;
        }else{
            if(x >= Min)
                stack.push(x);
            else{
                stack.push(2*x - Min);
                Min = x;
            }
        }
    }
    private static int pop(){
        if(stack.isEmpty())
            return -1;

        if(stack.peek() >= Min)
            return stack.pop();
        else {
            int y = Min;
            Min = 2*Min - stack.peek();
            stack.pop();
            return y;
        }
    }
    private static int top(){
        if(stack.isEmpty())
            return -1;
        return stack.peek() >= Min ? stack.peek() : Min;
    }
    private static int getMin(){
        return stack.isEmpty() ? -1 : Min;
    }
}

/*
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
 */
