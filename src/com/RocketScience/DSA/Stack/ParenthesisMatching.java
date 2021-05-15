package com.RocketScience.DSA.Stack;

import java.util.Stack;

public class ParenthesisMatching {
    public static void main(String[] args) {
        //Arrays.stream(shuffle(new int[]{2,5,1,3,4,7}, 3)).forEach(System.out::println);
        System.out.println(isbalanced("[({[([{}])]})}"));
    }
    public static boolean isBalanced(String exp){ // for normal parenthesis
        Stack<Character> stack = new Stack<>();
        for(char c : exp.toCharArray()){
            if(c == '(')
                stack.push(c);
            else if(c == ')'){
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static boolean isbalanced(String exp){
        Stack<Character> stack = new Stack<>();
        for(char c : exp.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;

                char x = stack.pop();
                if(c == '}' && x != '{')
                    return false;
                else if(c == ')' && x != '(')
                    return false;
                else if(c == ']' && x !='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
