package com.RocketScience.DSA.Strings;

public class Anagrams {
    public static void main(String[] args) {
        String a = "b",b = "d";
        System.out.println(isAnagram(a,b));
    }
    private static boolean isAnagram(String a,String b){
        int[] H = new int[256];

        if(a.length() != b.length())
            return false;

        for(int i = 0;i<a.length();i++){
            H[a.charAt(i)]++;
            H[b.charAt(i)]--;
        }

        for(int x : H){
            if(x != 0)
                return false;
        }

        return true;
    }
}