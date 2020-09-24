package com.RocketScience.DSA.strings;

public class PermutationOfString {
    public static void main(String[] args) {
        permute("ABC", 0,2);
    }
    private static void permute(String s,int start,int end){ //Time Complexity O(n*n!)
        if(start == end)
            System.out.println(s);
        else{
            for(int i = start;i<=end;i++){
                s = swap(s,start,i);
                permute(s,start+1,end);
                s = swap(s,start,i);
            }
        }
    }
    private static String swap(String s, int i1, int i2) {
        char temp;
        char[] arr = s.toCharArray();
        temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
        return String.valueOf(arr);
    }
}
