package com.kondc.dsa.recursion;

/**
 * sum of 1-N numbers using recursion
 * 1) parameterized way
 * 2) functional way (using return statement)
 */
public class RecursionBasics2 {

    //parameterized way
    void sum(int i, int N, int result) {
        if(i>N){
            System.out.println(result);
            return;
        }
        sum(i+1, N, result+i);
    }

    //functional way
    int sum1(int i, int N) {
        if(i>N){
            return 0;
        }
        return i+sum1(i+1, N);
    }

    public static void main(String[] args) {
        RecursionBasics2 r = new RecursionBasics2();
        int N = 11;
        System.out.print("Sum of 1-N numbers (parameterized way): ");
        r.sum(1, N, 0);

        System.out.print("\nSum of 1-N numbers (functional way): ");
        int finalResult = r.sum1(1,N);
        System.out.print(finalResult);
    }
}
