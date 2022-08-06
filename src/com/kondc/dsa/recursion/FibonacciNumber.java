package com.kondc.dsa.recursion;

public class FibonacciNumber {

    int fibonacci(int i) {
        if(i<=1)
            return i;
        return fibonacci(i-1) + fibonacci(i-2);
    }

    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        System.out.println(fn.fibonacci(5));
    }
}
