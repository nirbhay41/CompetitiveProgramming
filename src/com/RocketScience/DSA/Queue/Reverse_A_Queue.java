package com.RocketScience.DSA.Queue;

import java.util.Queue;
import java.util.Stack;

public class Reverse_A_Queue {
    public static void main(String[] args) {

    }

    public static void iter_rev(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();

        while(!q.isEmpty()){
            stack.push(q.remove());
        }

        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }

    public static void recur_rev(Queue<Integer> q){
        if(q.isEmpty())
            return;

        int x = q.remove();
        recur_rev(q);
        q.add(x);
    }
}
