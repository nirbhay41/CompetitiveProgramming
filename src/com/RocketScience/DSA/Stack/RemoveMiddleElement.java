package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class RemoveMiddleElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        removeMiddle(stack,stack.size());
        System.out.println(stack);
    }

    public static void removeMiddle(Stack<Integer> stack,int sizeOfStack){
        delete_util(stack,sizeOfStack,0);
    }

    public static void delete_util(Stack<Integer> stack,int sizeOfStack,int curr){
        if(curr == sizeOfStack/2){
            stack.pop();
            return;
        }

        int x = stack.pop();
        delete_util(stack,sizeOfStack,curr+1);
        stack.push(x);
    }
}
