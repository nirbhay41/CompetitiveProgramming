package com.RocketScience.DSA.Strings;

public class NaivePatternSearching {
    public static void main(String[] args) {
        match_improved("hello World", "W");
    }

    //Time: O(N^2)
    public static void match_basic(String str,String pat){
        int n = str.length();
        int m = pat.length();

        for(int i = 0;i<n-m+1;i++){
            int j;
            for(j = 0;j<m;j++){
                if(str.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == m)
                System.out.print(i+" ");
        }
    }

    //Time: O(N)   For Distinct Pattern
    public static void match_improved(String str,String pat){
        int n = str.length();
        int m = pat.length();

        for(int i = 0;i<n-m+1;){
            int j;
            for(j = 0;j<m;j++){
                if(str.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == m)
                System.out.print(i+" ");
            if(j == 0)
                i++;
            else i = i+j;
        }
    }
}
