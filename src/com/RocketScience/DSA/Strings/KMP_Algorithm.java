package com.RocketScience.DSA.Strings;

public class KMP_Algorithm {
    public static void main(String[] args) {
        kmp("Kya bolti public", "olti");
    }

    //Time: O(N)
    public static void fill_lps(String str,int[] lps){
        int n = str.length(),i = 1,len = 0;
        lps[0] = 0;
        while(i < n){
            if(str.charAt(len) == str.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                }else len = lps[len-1];
            }
        }
    }

    //Time: O(N)  Space: O(N)
    public static void kmp(String str,String pat){
        int n = str.length();
        int m = pat.length();

        int[] lps = new int[m];
        fill_lps(pat,lps);
        int i = 0,j = 0;

        while(i < n){
            if(str.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                System.out.print(i-j+ " ");
                j = lps[j-1];
            }else if(i < n && str.charAt(i) != pat.charAt(j)){
                if(j == 0) i++;
                else j = lps[j-1];
            }
        }
    }
}
