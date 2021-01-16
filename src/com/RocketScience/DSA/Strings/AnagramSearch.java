package com.RocketScience.DSA.Strings;

public class AnagramSearch {
    public static void main(String[] args) {
        System.out.println(search("geeksforgeeks", "frog"));
    }

    //Find if pattern is present or permutation of that pattern is present
    //Time: O(m + (n-m)*CHAR)  Space: O(CHAR)  where CHAR = 256
    public static boolean search(String str,String pat){
        char[] CT = new char[256];
        char[] CP = new char[256];
        int n = str.length();
        int m = pat.length();

        for(int i = 0;i<m;i++){  // Theta(m)
            CT[str.charAt(i)]++;
            CP[pat.charAt(i)]++;
        }

        for(int i = m;i<n;i++){ // O((n-m)*CHAR)
            if(areSame(CT,CP))
                return true;
            CT[str.charAt(i)]++;
            CT[str.charAt(i-m)]--;
        }

        return false;
    }

    private static boolean areSame(char[] a, char[] b) {
        for(int i = 0;i<a.length;i++){
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
}
