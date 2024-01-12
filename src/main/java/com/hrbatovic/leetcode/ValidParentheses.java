/*
 * Copyright (c) 2000 - 2024 by Raiffeisen Software GmbH.
 * All rights reserved.
 *
 */
package com.hrbatovic.leetcode;

import java.util.Stack;

public class ValidParentheses {

    //accepted, Runtime 2 ms Beats 75.49% of users with Java, Memory 41.09 MB Beats 45.17% of users with Java
    public static void main(String[] args) {
        System.out.println("() Is valid: " + isValid("()"));
        System.out.println("[] Is valid: " + isValid("[]"));
        System.out.println("{) Is valid: " + isValid("{)"));
        System.out.println("()[]{} Is valid: " + isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();

        char chars[] = s.toCharArray();

        for(int i = 0; i < chars.length; i ++){
            if(chars[i]=='(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            } else if(stack.isEmpty()){
                return false;
            } else if((char) stack.lastElement()=='(' && s.charAt(i)==')'){
                stack.pop();
            } else if((char) stack.lastElement()=='{' && s.charAt(i)=='}'){
                stack.pop();
            } else if((char) stack.lastElement()=='[' && s.charAt(i)==']'){
                stack.pop();
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}
