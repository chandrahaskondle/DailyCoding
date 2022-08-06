package com.kondc.dsa.problems;

import java.util.ArrayList;
import java.util.List;

/**
 *  Print all subsequences - Power Set.
 *  concept used: Bit Manipulation
 */
public class PowerSet {

    private static void printAllSubSequences(int arr[]) {
        int n = arr.length;
        for(int i=1; i<(1<<n); i++){
            StringBuilder sb = new StringBuilder();
            int num = i, j = 0;
            List<Integer> list = new ArrayList<>();
            while(num > 0) {
                if(num%2 == 1)
                    list.add(arr[j]);
                num = num/2;
                j++;
            }
            for(Integer x: list){
                sb.append(x+" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        printAllSubSequences(arr);
    }

    private static int power(int a, int b) {
        int result = 1;
        for(int i=0; i<b/2; i++){
            result *= a;
        }
        result  *= result;
        if(b%2!=0)
            result *= a;
        return result;
    }
}
