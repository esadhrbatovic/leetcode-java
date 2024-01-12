package com.hrbatovic.leetcode;

public class PalindromeNumber {
    //accepted, 6 ms Beats 46.09% of users with Java, 44.44 MB Beats 5.79% of users with Java
    public static void main(String[] args) {
        System.out.println("121 is palindrome number: " + isPalindrome(121));
        System.out.println("-121 is palindrome number: " + isPalindrome(-121));
        System.out.println("10 is palindrome number: " + isPalindrome(10));
    }

    static public boolean isPalindrome(int x) {
        char[] chars = ("" +x).toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            if(chars[i] != chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
}