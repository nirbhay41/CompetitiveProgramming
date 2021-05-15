package com.RocketScience.DSA.Strings;

public class CheckIfStringsAreRotations {
    public static void main(String[] args) {
        System.out.println(isRotations("ABCD", "ABBA"));
    }

    ///Time: O(N)
    public static boolean isRotations(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        return (s1 + s1).contains(s2);  // ABCD --> BCDA --> ABCDABCD
    }
}
