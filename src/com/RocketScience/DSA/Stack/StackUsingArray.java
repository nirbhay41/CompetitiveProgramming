package com.RocketScience.DSA.Stack;

class Stack{
    public int size;
    public int TOP;
    public int[] s;

    public Stack(int size){
        this.size = size;
        s = new int[size];
        TOP = -1;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack stk = new Stack(5);
        push(stk,5);
        push(stk,4);
        push(stk,2);
        push(stk,6);
        display(stk);
        System.out.println(peek(stk,1));
        System.out.println(peek(stk,5));
    }
    public static void display(Stack stk){
        for(int i = stk.TOP;i>=0;i--)
            System.out.println(stk.s[i]);
        System.out.println();
    }
    public static void push(Stack stk,int x){
        if(stk.TOP == stk.size-1){
            System.out.println("STACK OVERFLOW!!!");
        }else stk.s[++stk.TOP] = x;
    }
    public static int pop(Stack stk){
        int x = -1;
        if(stk.TOP == -1){
            System.out.println("STACK UNDERFLOW!!!");
        }else{
            x =  stk.s[stk.TOP--];
        }
        return x;
    }
    public static int peek(Stack stk,int pos){
        int x = -1;
        if((stk.TOP-pos+1) < 0){
            System.out.println("Invalid Position!!!");
        }else{
            x = stk.s[stk.TOP-pos+1];
        }
        return x;
    }
    public static boolean isEmpty(Stack stk){
        return stk.TOP == -1;
    }
    public static boolean isFull(Stack stk){
        return stk.TOP == stk.size-1;
    }
    public static int stackTop(Stack stk){
        if(!isEmpty(stk))
            return stk.s[stk.TOP];
        return -1;
    }
}
