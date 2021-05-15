package com.RocketScience.DSA.Strings;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(areIsomorphic("aab", "xxy"));
    }

    public static boolean areIsomorphic(String s1,String s2) {
        if(s1.length() != s2.length())
            return false;

        char[] map = new char[256];
        boolean[] visited = new boolean[256];

        for(int i = 0;i<s1.length();i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(map[a] != 0){
                if(map[a] != b)
                    return false;
            }else{
                if(visited[b])
                    return false;
                else{
                    map[a] = b;
                    visited[b] = true;
                }
            }
        }

        return true;
    }
}
