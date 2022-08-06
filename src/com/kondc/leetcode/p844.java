package com.kondc.leetcode;

import java.util.Stack;

public class p844 {

    public static void main(String[] args) {

    }

    public String build(String str) {
        Stack<Character> stack = new Stack<>();
        for(Character c: str.toCharArray()){
            if(c.equals(new Character('#')) && !stack.isEmpty()){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.toString();
    }
}
