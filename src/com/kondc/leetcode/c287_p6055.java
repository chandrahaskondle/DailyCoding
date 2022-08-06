package com.kondc.leetcode;

public class c287_p6055 {
    public int convertTime(String current, String correct) {
        int result = 0;
        int operations[] = {1,5,15};
        String currentArr[] = current.split(":");
        String correctArr[] = current.split(":");
        int hours = Integer.parseInt(correctArr[0])-Integer.parseInt(currentArr[0]);
        result += hours;

        int minutes = Integer.parseInt(correctArr[1])-Integer.parseInt(currentArr[1]);
        int tempM = minutes;
        int i = 2;

        while(tempM > 0 && i >= 0){
            result += tempM / operations[i];
            if( tempM % operations[i] == 0 ){
                break;
            } else {
                tempM = tempM % operations[i];
            }
            i--;
        }

        return result;
    }
}
