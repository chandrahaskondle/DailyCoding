package com.kondc.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all subsequences using recursion
 * Print all subsequences with sum K
 */

public class PrintingSubsequences {
    int[] array = {3,1,2,4,5};
    int n = array.length;
    int k = 5;

    public void findAllSubsequences(int index, List aList) {
        if(index >= n) {
            printCurrentSubsequence(aList);
            return;
        }
        // pick the element
        aList.add(array[index]);
        findAllSubsequences(index+1, aList);

        aList.remove(aList.size() - 1);
        // don't pick the element
        findAllSubsequences(index+1, aList);
    }

    public void subsequencesWithSum(int index, List aList, int sum) {
        if(index == n) {
            if(sum == k){
                printCurrentSubsequence(aList);
            }
            return;
        }
        // pick the element
        aList.add(array[index]);
        sum += array[index];
        subsequencesWithSum(index+1, aList, sum);

        aList.remove(aList.size() - 1);
        sum -= array[index];
        // don't pick the element
        subsequencesWithSum(index+1, aList, sum);
    }

    public boolean firstSubsequencesWithSum(int index, List aList, int sum) {
        if(index == n) {
            if(sum == k){
                printCurrentSubsequence(aList);
                return true;
            }
            return false;
        }
        // pick the element
        aList.add(array[index]);
        sum += array[index];
        if(firstSubsequencesWithSum(index+1, aList, sum) == true) {
            return true;
        }

        aList.remove(aList.size() - 1);
        sum -= array[index];
        // don't pick the element
        return firstSubsequencesWithSum(index+1, aList, sum);
    }

    public int countSubsequencesWithSum(int index, int sum) {
        if(index == n) {
            if(sum == k)
                return 1;
            return 0;
        }
        // pick the element
        sum += array[index];
        int leftResult = countSubsequencesWithSum(index+1, sum);

        sum -= array[index];
        // don't pick the element
        int rightResult = countSubsequencesWithSum(index+1, sum);

        return leftResult + rightResult;
    }

    public void printCurrentSubsequence(List aList){
        System.out.println(aList.toString());
    }

    public static void main(String[] args) {
        PrintingSubsequences p1 = new PrintingSubsequences();

        System.out.println("Print all subsequences");
        List<Integer> aList = new ArrayList<>();
        p1.findAllSubsequences(0, aList);

        System.out.println("Print all subsequences with sum k="+ p1.k);
        List<Integer> aList2 = new ArrayList<>();
        p1.subsequencesWithSum(0, aList2, 0);

        System.out.println("Print one subsequences with sum k="+ p1.k);
        List<Integer> aList3 = new ArrayList<>();
        p1.firstSubsequencesWithSum(0, aList3, 0);

        System.out.println("Count of subsequences with sum k="+ p1.k);
        System.out.println(p1.countSubsequencesWithSum(0, 0));
    }

}
