package com.demo.springboot_cache.test.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {

    public static void main(String args[]){

        List<Integer> integerList = List.of(5, 7, 6, 3, 1, 2, 4, 2, 1, 7, 6, 5, 3);
        System.out.println(findLonelyInteger(integerList));
    }

    public static int findLonelyInteger(List<Integer> integerList){
        Map<Integer, Integer> map = new HashMap<>();


        integerList.stream().forEach(item -> {
            map.put(item, map.getOrDefault(item, 0) + 1);
        });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        System.out.println(map);
        return 0;
    }
}
