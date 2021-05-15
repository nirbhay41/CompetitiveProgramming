package com.RocketScience.DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;


public class GenerateNumbers {
    public static void main(String[] args) {
        printFirstN(10);
    }

    //Print Numbers with only 5 and 6 digits in it up to n
    public static void printFirstN(int n){
        Queue<String> q = new LinkedList<>();

        q.add("5");
        q.add("6");

        for(int i = 0;i<n;i++){
            String curr = q.remove();
            System.out.println(curr);
            q.add(curr+"5");
            q.add(curr+"6");
        }
    }
}
