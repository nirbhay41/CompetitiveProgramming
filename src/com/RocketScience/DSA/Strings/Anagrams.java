package com.RocketScience.DSA.Strings;

public class Anagrams {
    public static void main(String[] args) {
        String a = "decimal",b = "medical";
        System.out.println(isAnagram(a,b));
    }
    private static boolean isAnagram(String a,String b){
        int[] H = new int[26];
        int i;
        if(a.length() != b.length())
            return false;
        else {
            for (i = 0; i < a.length(); i++)
                H[a.charAt(i) - 97]++;
            for (i = 0; i < b.length(); i++) {
                H[b.charAt(i) - 97]--;
                if (H[b.charAt(i) - 97] < 0) {
                    return false;
                }
            }
            return i == b.length();
        }
    }
}