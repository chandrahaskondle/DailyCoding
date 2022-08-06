package com.kondc.dsa.recursion;

/**
 * (recursion) print N to 1 numbers.
 * use backtracking technique
 */
public class RecursionBasics1 {

    void printNumbers(int i, int N) {
        if(i<1)
            return;
        System.out.print(i+ " ");
        printNumbers(i-1, N);
    }

    // using recursion & backtracking
    void printNumbers_Backtracking(int i, int N) {
        if(i>N)
            return;
        printNumbers_Backtracking(i+1 , N);
        System.out.print(i + " ");
    }

    public static void main(String[] args) {
        RecursionBasics1 r = new RecursionBasics1();
        int N = 10;

        System.out.println("Print N to 1 using recursion");
        r.printNumbers(N, N);

        System.out.println("\n\nPrint N to 1 using recursion & backtracking");
        r.printNumbers_Backtracking(1, N);
    }
}
