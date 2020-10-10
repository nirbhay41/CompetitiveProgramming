package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class MinStackWithExtraSpace {
    private static final Stack<Integer> s = new Stack<>();
    private static final Stack<Integer> ss = new Stack<>();

    public static void main(String[] args) {
        push(5);
        push(6);
        push(3);
        push(10);
        push(1);
        System.out.println(getMin());
    }
    private static void push(int x){
        s.push(x);
        if(ss.isEmpty() || x <= ss.peek()){
            ss.push(x);
        }
    }
    private static int pop(){
        if(s.isEmpty())
            return -1;
        int x = s.pop();
        if(x == ss.peek())
            ss.pop();
        return x;
    }
    private static int getMin(){
        if(ss.isEmpty())
            return -1;
        return ss.peek();
    }
}
