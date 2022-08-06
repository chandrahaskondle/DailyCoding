package com.kondc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class c287_p5235 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<=matches.length; i++){
            if(!map.containsKey(matches[i][0]))
                map.put(matches[i][0], 0);
            if(map.containsKey(matches[i][1]))
                map.put(matches[i][1], map.get(matches[i][1])+1);
            else
                map.put(matches[i][1], 1);
        }

        for(Integer i : map.keySet()){
            if(map.get(i) == 0){
                result.get(0).add(i);
            }
            if(map.get(i) == 1) {
                result.get(1).add(i);
            }
        }

        return result;
    }
}
