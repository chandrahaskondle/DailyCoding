package com.kondc.dsa.recursion;

import java.util.Arrays;

public class ReverseArray {
    int arr[] = {1,2,3,4,5};

    int n = arr.length;

    private void reverse(int i) {
        if(i>=n/2)
            return;
        swap(i,n-i-1);
        reverse(i+1);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ReverseArray R3 = new ReverseArray();

        System.out.println(Arrays.toString(R3.arr) );

        R3.reverse(0);

        System.out.println(Arrays.toString(R3.arr) );
    }
}
