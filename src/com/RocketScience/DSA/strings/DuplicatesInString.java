package com.RocketScience.DSA.strings;

/*
This is done with the help of BitWise Operations(We can't count how many duplicates)
We can also use Hashing here(We can count how many duplicates)
 */

public class DuplicatesInString {
    public static void main(String[] args) {
        String s = "findings";
        int H = 0;

        for(int i = 0;i<s.length();i++){
            int x = 1;
            x = x << s.charAt(i) - 97;
            if((H & x) > 0)
                System.out.printf("%c is duplicate\n",s.charAt(i));
            else H = H | x;
        }
    }
}
