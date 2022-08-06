package com.kondc.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */

public class CombinationSum {
    int[] arr = {2, 3, 5};
    int n = arr.length;
    int targetSum = 8;

    public void printSubsequences(int i, int sum, int target, List<Integer> list) {
        if(i == n || sum >= target){
            if(sum == target) {
                print(list);
            }
            return;
        }
        sum += arr[i];
        list.add(arr[i]);
        printSubsequences(i, sum, target, list);

        sum -= arr[i];
        list.remove(list.size()-1);
        printSubsequences(i+1, sum, target, list);
    }

    public void print(List<Integer> list) {
        StringBuilder sb = new StringBuilder("");
        for(Integer i: list){
            sb.append(i+ " ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        CombinationSum c1 = new CombinationSum();
        c1.printSubsequences(0, 0, c1.targetSum, new ArrayList<>());
    }
}


