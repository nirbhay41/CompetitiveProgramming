package com.RocketScience.DSA.Stack;

public class TwoStack {
    int[] a;
    int cap,top1,top2;

    public TwoStack(int cap) {
        this.cap = cap;
        top1 = -1;
        top2 = cap;
        a = new int[cap];
    }

    void push1(int x){
        if(top1 < top2 - 1){
            top1++;
            a[top1] = x;
        }
    }

    void push2(int x){
        if(top1 < top2-1){
            top2--;
            a[top2] = x;
        }
    }

    int pop1(){
        if (top1 >= 0){
            int x = a[top1];
            top1--;
            return x;
        }
        return -2;
    }

    int pop2(){
        if(top2 < cap){
            int x = a[top2];
            top2++;
            return x;
        }
        return -2;
    }
}
