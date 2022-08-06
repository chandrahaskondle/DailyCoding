package com.kondc.dsa.recursion;

public class CheckPalindrome {
    String str = "madam"; // "abcdbcba";
    int n = str.length();

    boolean isPalindrome(int i) {
        if(i>=n/2)
            return true;
        if(str.charAt(i) != str.charAt(n-i-1))
            return false;
        return isPalindrome(i+1);
    }

    public static void main(String[] args) {
        CheckPalindrome cp = new CheckPalindrome();
        System.out.println("This String is a palindrome: " + cp.isPalindrome(0));
    }
}
