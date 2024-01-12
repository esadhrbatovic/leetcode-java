package com.hrbatovic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    //accepted, Runtime 5 ms Beats 58.91% of users with Java, Memory 44.63 MB Beats 27.04% of users with Java

    public static void main(String[] args) {
        System.out.println("III roman to integer: " + romanToInt("III"));
        System.out.println("LVIII roman to integer: " + romanToInt("LVIII"));
        System.out.println("MCMXCIV roman to integer: " + romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] c = s.toCharArray();
        int res = 0;
        for (int i = c.length-1; i>=0; i--){
            res += map.get(c[i]);

            if(i == 0){
                break;
            }

            if(map.get(c[i-1])<map.get(c[i])){
                res-= map.get(c[i-1]);
                i--;
            }
        }
        return res;
    }
}