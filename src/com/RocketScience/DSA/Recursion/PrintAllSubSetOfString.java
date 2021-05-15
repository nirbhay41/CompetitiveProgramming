package com.RocketScience.DSA.Recursion;

public class PrintAllSubSetOfString {
    public static void main(String[] args) {
        printSubset("ABC","",0);
    }

    public static void printSubset(String s,String current,int index){
        if(index == s.length()){
            System.out.println(current);
            return;
        }

        printSubset(s,current, index+1);
        printSubset(s,current+s.charAt(index), index+1);
    }
}
