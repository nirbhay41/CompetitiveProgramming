package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(postfix("10+2*3/4"));
    }

    public static String postfix(String exp){
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0;i<exp.length();i++){
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c))
                res.append(c);
            else if(c == '(')
                stack.push(c);
            else if(c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    res.append(stack.pop());
                stack.pop();
            }else{
                while (!stack.isEmpty() && preced(c) <= preced(stack.peek()))
                    res.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static int preced(char op){
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
