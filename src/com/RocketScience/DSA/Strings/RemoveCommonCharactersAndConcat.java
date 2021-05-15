package com.RocketScience.DSA.Strings;


//Asked in Microsoft
public class RemoveCommonCharactersAndConcat {
    public static void main(String[] args) {
        System.out.println(concatenatedString("rqunudsgdgbcuyqywbvghxsuakuefup",
                "wkjjeocntkowhoofkrbszakvdvrhamyywhidymstwgpdxglhxmcyoourlnz"));
    }

    public static String concatenatedString(String s1,String s2){
        int[] H = new int[26];
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s2.length();i++)
            H[s2.charAt(i)-'a'] = 1; // if it appears in one string then count of that character is 1

        for(int i = 0;i<s1.length();i++){
            if(H[s1.charAt(i)-'a'] == 0)
                sb.append(s1.charAt(i));
            else H[s1.charAt(i)-'a'] = 2; // if it occurs in both string then count of that character is 2
        }

        for(int i = 0;i<s2.length();i++)
            if(H[s2.charAt(i)-'a'] == 1)
                sb.append(s2.charAt(i));

        return !sb.toString().equals("") ? sb.toString() : "-1";
    }
}
