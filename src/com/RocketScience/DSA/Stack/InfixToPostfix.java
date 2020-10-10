package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(infixToPostFix("a+b*c/d"));
    }

    static String infixToPostFix(final String expression){

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()){
            //check if char is operator
            if(precedence(c)>0){
                while(!stack.isEmpty() && precedence(stack.peek())>=precedence(c)){
                    result.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    result.append(x);
                    x = stack.pop();
                }
            }else if(c=='('){
                stack.push(c);
            }else{
                //character is neither operator nor (
                result.append(c);
            }
        }
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    static int precedence(char c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
