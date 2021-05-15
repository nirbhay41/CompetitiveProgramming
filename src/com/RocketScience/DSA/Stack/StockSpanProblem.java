package com.RocketScience.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        Arrays.stream(stock(new int[]{100,80,60,70,60,75,85})).forEach(System.out::print);
    }
    private static int[] stock(int[] price){ // We have to find the index of nearest greatest element to left
        int[] span = new int[price.length];
        Stack<Integer> stack_day = new Stack<>();
        stack_day.push(0);
        span[0] = 1;
        for(int days = 1;days<price.length;days++){
            while (!stack_day.isEmpty() && price[stack_day.peek()] <= price[days])
                stack_day.pop();

            span[days] = (stack_day.isEmpty()) ? days+1 : days-stack_day.peek();
            stack_day.push(days);
        }
        return span;
    }
}
