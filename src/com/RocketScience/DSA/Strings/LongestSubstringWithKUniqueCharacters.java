package com.RocketScience.DSA.Strings;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aabacbebebe", 3));
    }

    //Sliding Window
    public static String longestSubstring(String s, int k){
        HashMap<Character,Integer> map = new HashMap<>();

        int start = 0,maxLength = 0,maxStart = -1;

        for(int end = 0;end<s.length();end++){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);

            if(map.size() == k){
                if(end - start + 1 > maxLength){
                    maxStart = start;
                    maxLength = end-start+1;
                }
            }else if(map.size() > k){
                while (map.size() > k){
                    char temp = s.charAt(start);
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp)-1);
                        if(map.get(temp) == 0)
                            map.remove(temp);
                    }
                    start++;
                }
            }
        }

        return s.substring(maxStart,maxStart+maxLength);
    }
}
