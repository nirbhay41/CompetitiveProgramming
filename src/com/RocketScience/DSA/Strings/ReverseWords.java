package com.RocketScience.DSA.Strings;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("".toCharArray()));
    }

    //We are using this trick --> 123 456 --> 321 654 --> 456 123

    public static String reverseWords(char[] a){
        int start = 0;

        for(int end = 0;end < a.length;end++){
            if(a[end] == ' '){
                reverse(a,start,end-1);
                start = end+1;
            }
        }
        reverse(a,start,a.length-1); // reversing the last word
        reverse(a,0,a.length-1);

        return new String(a);
    }

    private static void reverse(char[] a, int start, int end) {
        while(start<end){
            char c = a[start];
            a[start] = a[end];
            a[end] = c;
            start++;
            end--;
        }
    }
}
