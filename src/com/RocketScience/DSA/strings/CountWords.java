package com.RocketScience.DSA.strings;

public class CountWords {
    public static void main(String[] args) {
        String s = "This is my Job and i s     a  hould do it";
        int word = 1;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' ' && s.charAt(i-1) != ' ') // s.charAt(i-1) is for whitespaces in the string
                word++;
        }
        System.out.println(word);
    }
}
