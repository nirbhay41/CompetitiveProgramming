package com.RocketScience.DSA.Strings;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=GZjW14vX2Ps
//Smallest window in a string containing all the characters of another string (MEDIUM)(IMP)
public class SmallestWindowInAString {
    public static void main(String[] args) {
        System.out.println(smallestWindow("timetopractice", "toc"));
    }

    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length())
            return "-1";

        int count = 0, start = 0, minSubstringLength = Integer.MAX_VALUE, minSubstringStart = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++)
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0)+1);

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            //Find first window containing all characters of pattern
            if(map.containsKey(currentChar)){
                map.put(currentChar,map.get(currentChar)-1);
                if(map.get(currentChar) >= 0)
                    count++;
            }

            //Now Try to minimize the window
            while (count == p.length()){
                if(end - start + 1 < minSubstringLength){
                    minSubstringLength = end - start + 1;
                    minSubstringStart = start;
                }

                char charAtStart = s.charAt(start++);

                if(map.containsKey(charAtStart)){
                    if(map.get(charAtStart) == 0)
                        count--;
                    map.put(charAtStart,map.get(charAtStart)+1);
                }
            }
        }

        if(minSubstringLength > s.length())
            return "";

        return s.substring(minSubstringStart,minSubstringStart+minSubstringLength);
    }
}