package com.RocketScience.DSA.Strings;

public class BinaryString {
    public static void main(String[] args) {
        System.out.println(getSubString("1111"));
    }

    //Count no of substrings starts and ends with 1
    //Efficient Approach: nC2 (no of ways to select a pair of 1's)
    public static int getSubString(String str){
        int n = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == 1)
                n++;
        }
        return n*(n-1)/2;
    }
}
