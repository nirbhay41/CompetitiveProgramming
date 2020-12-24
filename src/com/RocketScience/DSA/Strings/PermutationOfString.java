package com.RocketScience.DSA.Strings;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "ABCDEFGH";
        permute(s, 0,s.length()-1);
    }
    private static void permute(String s,int start,int end){ //Time Complexity O(n*n!)
        if(start == end)
            System.out.println(s);
        else{
            for(int i = start;i<=end;i++){
                s = swap(s,start,i);  // fix ith character at start position
                permute(s,start+1,end); // after fixing
                s = swap(s,start,i); // Backtrack to original form
            }
        }
    }
    private static String swap(String s, int i, int j) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}
