package com.hrbatovic.leetcode;

public class LongestCommonPrefix {
    //both accepted,
    // 1: Runtime 8 ms Beats 16.19% of users with Java, Memory 41.92 MB Beats 11.97% of users with Java
    // 2: Runtime 1 ms Beats 81.83% of users with Java, Memory 41.11 MB Beats 48.24% of users with Java

    public static void main(String[] args) {

        System.out.println("{flower, flow, flight} Longest common prefix: " + longestCommonPrefix(new String[]{"flower", "flow", "flon"}));
        System.out.println("{a} Longest common prefix: " + longestCommonPrefix(new String[]{"a"}));
        System.out.println("{c, acc, ccc} Longest common prefix: " + longestCommonPrefix(new String[]{"c","acc","ccc"}));
        System.out.println("--------------");
        System.out.println("{flower, flow, flight} Longest common prefix: " + longestCommonPrefix2(new String[]{"flower", "flow", "flon"}));
        System.out.println("{a} Longest common prefix: " + longestCommonPrefix2(new String[]{"a"}));
        System.out.println("{c, acc, ccc} Longest common prefix: " + longestCommonPrefix2(new String[]{"c","acc","ccc"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        int charIndex = 0;

        while(charIndex < strs[0].length()){
            boolean match = false;

            for(int i = 0; i < strs.length; i++){
                if(strs[i].length()-1 >= charIndex){
                    return res;
                }
                if( strs[0].charAt(charIndex) == strs[i].charAt(charIndex)){
                    match = true;
                }else{
                    match = false;
                    break;
                }
            }
            if(match){
                res += strs[0].charAt(charIndex);
            }else{
                return res;
            }
            charIndex++;
        }

        return res;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String firstString = strs[0];
        int prefixLength = firstString.length();

        for (int i = 1; i < strs.length; i++) {
            int charIndex = 0;
            while (charIndex < prefixLength && charIndex < strs[i].length() && firstString.charAt(charIndex) == strs[i].charAt(charIndex)) {
                charIndex++;
            }
            prefixLength = charIndex;
        }

        return firstString.substring(0, prefixLength);
    }
}